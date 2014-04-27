package com.huuuxi.jdk.thread;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class TestForkJoinPoolFile {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		FileProcessor file  = new FileProcessor("c:\\Windows", "log");
		FileProcessor app = new FileProcessor("c:\\Program Files", "log");
		FileProcessor doc = new FileProcessor("c:\\Documents And Settings", "log");
		pool.execute(file);
		pool.execute(app);
		pool.execute(doc);
		
		do {
			System.out.printf("******************************************\n");
			System.out.printf("Main: Parallelism: %d\n",pool.getParallelism());
			System.out.printf("Main: Active Threads: %d\n",pool.getActiveThreadCount());
			System.out.printf("Main: Task Count: %d\n",pool.getQueuedTaskCount());
			System.out.printf("Main: Steal Count: %d\n",pool.getStealCount());
			System.out.printf("*******************************************\n");
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} while (!file.isDone() || !app.isDone() || !doc.isDone());
		pool.shutdown();
		List<String> results = new ArrayList<String>();
		results = file.join();
		System.out.println("Windows log file size :" + results.size());
		results = app.join();
		System.out.printf("App log file size : %d" ,results.size());
		results = doc.join();
		System.err.printf("Doc log file size : %d",results.size());
	}
}

class FileProcessor extends RecursiveTask<List<String>>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String path;
	private String extension;
	public FileProcessor(){
		
	}
	public FileProcessor(String path,String extension){
		this.path = path;
		this.extension = extension;
	}
	
	@Override
	protected List<String> compute() {
		List<String> strs = new ArrayList<String>();
		List<FileProcessor> processors = new ArrayList<FileProcessor>();
		File file = new File(path);
		File[] content = file.listFiles();
		if (content != null) {
			for(File f : content){
				FileProcessor pro = new FileProcessor(f.getPath(), extension);
				processors.add(pro);
				pro.fork();
			}
		}else {
			if (file.getName().endsWith(extension)) {
				strs.add(file.getAbsolutePath());
			}
		}
		if (processors.size() > 50) {
			System.out.printf("%s ：%d tasks run . \n", file.getAbsolutePath(), processors.size());
		}
		addResultFromTasks(strs, processors);
		return strs;
	}
	
	private void addResultFromTasks(List<String> strs ,List<FileProcessor> pros){
		for(FileProcessor f : pros){
			strs.addAll(f.join());
		}
	}
	
}
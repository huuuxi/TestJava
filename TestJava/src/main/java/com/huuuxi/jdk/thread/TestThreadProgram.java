package com.huuuxi.jdk.thread;

public class TestThreadProgram {

	static void threadMessage(String message){
		String name = Thread.currentThread().getName();
		System.out.format("%s : %s%n", name ,message);
	}
	
	private static class MessageLoop implements Runnable{

		@Override
		public void run() {
			String[] importantInfo = new String[]{
					"Mess eat oats",
					"Does eat oats",
					"Litte lambs eat ivy",
					"A kit will eat ivy too"
			};
			for( int i =0 ;i < importantInfo.length; i ++){
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					threadMessage("i dont done");
				}
				threadMessage(importantInfo[i]);
			}
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		long patience  = 1000 *4;
		if (args.length > 0) {
			try {
				patience = Long.parseLong(args[0]) * 1000;
			} catch (NumberFormatException e) {
				System.err.println("Argument must be Number!");
				System.exit(-1);
			}
		}
		threadMessage("Starting the thread ....");
		Long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();
		threadMessage("Wait MessageLoop done.....");
		while(t.isAlive()){
			threadMessage("Still waiting");
			t.join(1000);
			if (System.currentTimeMillis() - startTime > patience) {
				threadMessage("Too tired of Waiting");
				t.interrupt();
				t.join();
			}
		}
		threadMessage("Finnally run over");
		
		
	}
}

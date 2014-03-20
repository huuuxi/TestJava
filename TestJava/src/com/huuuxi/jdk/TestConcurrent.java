package com.huuuxi.jdk;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created with IntelliJ IDEA.
 * User: wyliujiangbin
 * Date: 14-3-19
 * Time: 下午4:17
 * To change this template use File | Settings | File Templates.
 */
public class TestConcurrent {
    public static void testCopyOnWrite(){
        // 实现为CopyOnWrite；write的时候拷贝一份，在新拷贝里面写入，然后把就的地址指向新拷贝；cow；
        // 应用场景：读多写少，比如黑名单白名单；
        // 数据一致性：最终一致，不是实时；
        CopyOnWriteArrayList list;
        CopyOnWriteArraySet set;

    }
}

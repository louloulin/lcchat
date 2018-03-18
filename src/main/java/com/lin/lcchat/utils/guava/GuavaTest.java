/**
 * Copyright: Copyright (c)2011
 * Company: 易宝支付(YeePay)
 */
package com.lin.lcchat.utils.guava;

import com.google.common.base.Function;
import com.google.common.collect.*;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

/**
 * 类名称: GuavaTest <br>
 * 类描述:guava工具实验类 <br>
 *
 * @author: chong.lin
 * @date: 2018/1/27 上午10:22
 * @company: 易宝支付(YeePay)
 */
public class GuavaTest extends TestCase {
    @Test
    public void test() {
        boolean www = Objects.equals(null, "www");
        System.out.println(www);
    }

    @Test
    public void testCompare() {
        //  链式比较
        int result = ComparisonChain.start()
                .compare(2, 2)
                .compare(23, 22)
                .compare(33, 33, Ordering.natural().nullsLast())
                .result();
        System.out.println(result);

    }

    /**
     * 自定义排序器，排序是从后向前调用
     */
    public void testOrder() {
        Ordering<Foo> ordering = Ordering.natural().nullsFirst().onResultOf(new Function<Foo, String>() {
            public String apply(Foo foo) {
                return foo.sortedBy;
            }
        });
        Ordering<Foo> reverse = ordering.reverse();
        Foo foo1 = new Foo("1", 1);
        Foo foo2 = new Foo("2", 2);
        int compare = ordering.compare(foo1, foo2);
        System.out.println("****正向排序*****");
        System.out.println(compare);
        System.out.println("*****反向排序*****");
        System.out.println(reverse.compare(foo1, foo2));
        List<Integer> integers = Arrays.asList(-1, 4, 6, 7, 8, 11, 22, 34, 2, 5, 44, 334, 11);
        Integer min = Ordering.natural().min(integers);
        System.out.println("******迭代器类型取出最小值*****");
        System.out.println(min);
        // TODO 有问题
        List<Integer> integers1 = Ordering.natural().greatestOf(integers, 100);
        System.out.println("*****取出最大的2个数字*****");
        System.out.println(integers);
    }

    /**
     * 测试错误处理类
     */
    public void testThrow() {

    }

    public void testMultiSet() {
        List<String> strings = Arrays.asList("a", "b", "c", "c", "a");
        Multiset<String> multiset = HashMultiset.create(strings);
        int a = multiset.count("a");
        System.out.println("***元素的个数***");
        System.out.println(a);
        String s = multiset.toString();
        System.out.println(s);
        System.out.println("***返回set***");
        Set set = multiset.elementSet();
        System.out.println(set.toString());
        for (Multiset.Entry<String> stringEntry : multiset.entrySet()) {
            System.out.println(stringEntry.getElement() + "=" + stringEntry.getCount());
        }
    }

    /*Multimap
    每个有经验的Java程序员都在某处实现过Map<K, List<V>>或Map<K, Set<V>>，并且要忍受这个结构的笨拙。例如，Map<K, Set<V>>通常用来表示非标定有向图。Guava的 Multimap可以很容易地把一个键映射到多个值。换句话说，Multimap是把键映射到任意多个值的一般方式。

    可以用两种方式思考Multimap的概念：”键-单个值映射”的集合：

    a -> 1 a -> 2 a ->4 b -> 3 c -> 5

    或者”键-值集合映射”的映射：

    a -> [1, 2, 4] b -> 3 c -> 5

    一般来说，Multimap接口应该用第一种方式看待，但asMap()视图返回Map<K, Collection<V>>，让你可以按另一种方式看待Multimap。重要的是，不会有任何键映射到空集合：一个键要么至少到一个值，要么根本就不在Multimap中。*/
    public void testMultiMap() {

    }

    /*BiMap
    传统上，实现键值对的双向映射需要维护两个单独的map，并保持它们间的同步。但这种方式很容易出错，而且对于值已经在map中的情况，会变得非常混乱。例如：
    Map<String, Integer> nameToId = Maps.newHashMap();
    Map<Integer, String> idToName = Maps.newHashMap();

        nameToId.put("Bob", 42);
        idToName.put(42, "Bob");
//如果"Bob"和42已经在map中了，会发生什么?
        7
    //如果我们忘了同步两个map，会有诡异的bug发生...
    BiMap<K, V>是特殊的Map：

    可以用 inverse()反转BiMap<K, V>的键值映射
    保证值是唯一的，因此 values()返回Set而不是普通的Collection
    在BiMap中，如果你想把键映射到已经存在的值，会抛出IllegalArgumentException异常。如果对特定值，你想要强制替换它的键，请使用 BiMap.forcePut(key, value)。

*/
    public void testBiMap() {
        BiMap<String, Integer> userId = HashBiMap.create();
        userId.forcePut("lin", 1);
        userId.forcePut("hua", 2);
        String userForId = userId.inverse().get(1);
        Integer lin = userId.get("lin");
        System.out.println(userForId);
        System.out.println(lin);
    }

    /**
     * 多喝索引
     */
    public void testTable() {
        Table<Integer, Integer, Double> weightedGraph = HashBasedTable.create();
        weightedGraph.put(1, 1, 2.0);
        weightedGraph.put(1, 2, 1.0);
        weightedGraph.put(2, 1, 3.0);
        weightedGraph.put(2, 2, 4.0);
        Map<Integer, Map<Integer, Double>> integerMapMap = weightedGraph.columnMap();
        Double aDouble = integerMapMap.get(1).get(2);
        System.out.println(aDouble);
        System.out.println("********");
        Double aDouble1 = weightedGraph.get(1, 2);
        System.out.println(aDouble);

    }

    /**
     * key是类型，只是对应的对象
     */
    public void testClassToInstanceMap() {
        ClassToInstanceMap<Number> numberDefaults = MutableClassToInstanceMap.create();
        numberDefaults.putInstance(Integer.class, Integer.valueOf(0));
        Integer instance = numberDefaults.getInstance(Integer.class);
        System.out.println(instance);
    }

    /**
     * 不相连的区间
     */
    public void testRangeSet() {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10)); // {[1,10]}
        System.out.println(rangeSet.toString());
        rangeSet.add(Range.closedOpen(11, 15));//不相连区间:{[1,10], [11,15)}
        System.out.println(rangeSet.toString());
        rangeSet.add(Range.open(15, 20)); //相连区间; {[1,10], [11,20)}
        System.out.println(rangeSet.toString());
        rangeSet.add(Range.openClosed(0, 0)); //空区间; {[1,10], [11,20)}
        System.out.println(rangeSet.toString());
        rangeSet.remove(Range.open(5, 6)); //分割[1, 10]; {[1,5], [10,10], [11,20)}
        System.out.println(rangeSet.toString());
//        RangeSet的视图
//        RangeSet的实现支持非常广泛的视图：
//        complement()：返回RangeSet的补集视图。complement也是RangeSet类型,包含了不相连的、非空的区间。
//        subRangeSet(Range<C>)：返回RangeSet与给定Range的交集视图。这扩展了传统排序集合中的headSet、subSet和tailSet操作。
//        asRanges()：用Set<Range<C>>表现RangeSet，这样可以遍历其中的Range。
//        asSet(DiscreteDomain<C>)（仅ImmutableRangeSet支持）：用ImmutableSortedSet<C>表现RangeSet，以区间中所有元素的形式而不是区间本身的形式查看。（这个操作不支持DiscreteDomain 和RangeSet都没有上边界，或都没有下边界的情况）

    }

    public void testRangeMap() {
//        RangeMap描述了”不相交的、非空的区间”到特定值的映射。和RangeSet不同，RangeMap不会合并相邻的映射，即便相邻的区间映射到相同的值。例如：
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 10), "foo"); //{[1,10] => "foo"}
        rangeMap.put(Range.open(3, 6), "bar"); //{[1,3] => "foo", (3,6) => "bar", [6,10] => "foo"}
        rangeMap.put(Range.open(10, 20), "foo"); //{[1,3] => "foo", (3,6) => "bar", [6,10] => "foo", (10,20) => "foo"}
        rangeMap.remove(Range.closed(5, 11)); //{[1,3] => "foo", (3,5) => "bar", (11,20) => "foo"}
//        RangeMap的视图
//        RangeMap提供两个视图：
//        asMapOfRanges()：用Map<Range<K>, V>表现RangeMap。这可以用来遍历RangeMap。
//        subRangeMap(Range<K>)：用RangeMap类型返回RangeMap与给定Range的交集视图。这扩展了传统的headMap、subMap和tailMap操作。
    }

    /**
     * 集合工具类的运用
     */
    public void testCollectionsUtil() {
        List<Integer> strings = Lists.newArrayList(1,2,4);
        System.out.println(strings);
    }

}
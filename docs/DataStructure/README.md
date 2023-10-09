# 数据结构

## 线性数据结构

### 1.数组

**数组（Array）**是一种很常见的数据结构。它由相同类型的元素（element）组成，并且是使用一块连续的内存来存储

我们直接可以利用元素的索引（index）可以计算出该元素对应的存储地址。

数组的特点是：**提供随机访问**并且容量有限

> 假如数组的长度为 n。
>
> 访问：O（1）//访问特定位置的元素
>
> 插入：O（n）//最坏的情况发生在插入发生在数组的首位，会导致所有元素移动位置
>
> 删除：O（n）//最坏的情况发生在删除数组首位，会导致首位元素后的所有元素进行移位

![数组](/docs/image/数组.png)

### 2.链表

#### 2.1.链表简介

**链表（LinkedList）**虽然是一种线性表，但是并不会按线性的顺序存储数据，使用的不是连续的内存空间来存储数据。

链表的插入和删除操作的复杂的为 O（1），只需要知道目标位置元素的上一个元素即可。但是，在查找一个节点或者访问特定位置的节点的时间复杂度为 O（n）。

使用链表结构可以克服数组需要预先知道数据大小的缺点，链表结构可以充分利用计算机内存空间，实现灵活的内存动态管理。但链表不会节省空间，相比于数组会占用更多的空间，因为链表中每个节点存放的还有指向其他节点的指针。除此之外，链表不具有数组随机读取的优点。

#### 2.2.链表分类

**常见链表分类**：

1. 单链表
2. 双向链表
3. 循环链表
4. 双向循环链表

> 假如链表中由 n 个元素。
>
> 访问：O（n）//访问特定位置的元素
>
> 插入删除：O（1）//必须要知道插入元素的位置

##### 2.2.1.单链表

**单链表：**单向链表只有一个方向，结点只有一个后继指针 next 指向后面的节点。因此，链表这种数据结构通常在物理内存上是不连续的我们习惯性地把第一个节点叫做头节点。，链表通常有一个不保存任何值的 head 节点(头节点)，通过头节点我们可以遍历整个链表。尾节点通常指向 null。

![单链表](/docs/image/单链表.png)

##### 2.2.2循环链表

**循环链表**其实是一种特殊的单链表，如单链表不同的是循环表的尾节点不是指向 null，而是指向链表的头节点。

![循环链表](/docs/image/循环链表.png)

##### 2.2.3双向链表

**双向链表**包含两个指针，一个 prev 指向前一个节点，一个 next 指向后一个节点。

![双向链表](/docs/image/双向链表.png)

##### 2.2.4.双向循环链表

**双向循环链表**最后一个节点的 next 指向 head ，而 head 的 prev 指向最后一个节点，构成一个环。

![双向循环李彪](/docs/image/双向循环列表.png)

#### 2.3.应用场景

- 如果需要支持随机访问的话，链表没办法做到。
- 如果需要存储的数据元素的个数不确定，并且需要经常添加和删除数据的话，使用链表比较合适。
- 如果需要存储的数据元素个数确定，并且不需要经常添加和删除数据的话，使用数组比较合适。

#### 2.4.数组 VS 链表

- 数组支持随机访问，而链表不支持。
- 数组使用的是连续内存空间对 CPU 的缓存机制友好，链表则相反。
- 数组的大小固定， 而链表则天然支持动态扩容。如果声明的数组过小，需要另外申请一个更大的内存空间存放数组元素，然后将原数组拷贝进去，这个操作是比较耗时的！

### 3.栈

#### 3.1.栈简介

**栈（Stack）**只允许在有序的线性数据集合的一端（成为栈顶 top）进行加入数据（push）和移除数据（pop）。因而按照 **后进后出（LIFO，Last In Fist Out）** 的原理运作。**在栈中，push 和 pop 的操作都发生在栈顶。**

栈常用一维数组或链表来实现，用数组实现的栈叫做 **顺序栈**，用链表实现的栈叫做 **链式栈**。

> 假设堆栈中有 n 个元素。
>
> 访问：O（n）//最坏情况
>
> 插入数据：O（1）//顶端插入和删除元素

![栈](/docs/image/栈.png)

#### 3.2.栈的常见应用常见应用场景

当我们要处理的数据只涉及在一端插入和删除数据，并且满足 **后进后出（LIFO，Last In Fist Out）**的特性时，我们就可以使用栈这个数据结构。

##### 3.2.1.实现浏览器的回退和前进功能

我们只需要使用两个栈(Stack1 和 Stack2)就能实现这个功能。比如顺序查看了 1，2，3，4 这四个页面，我们一次把 1，2，3，4 这四个页面压入 Stack1 中。当想回头看 2 这个页面的时候，点击回退按钮，我们一次把 3，4 这两个页面从 Stack1 弹出，然后压入 Stack2 中。假如又想回到页面 3 ，点击前进按钮，我们将 3 页面从 Stack2 弹出，然后压入到 Stack1 中。示例图如下：

![栈实现浏览器倒退和前进](/docs/image/栈实现浏览器倒退和前进.png)

##### 3.3.2.检查符号是否成对出现

> **问题**
>
> 给定一个只包括 ``'('``,``')'``,``'{'``,``'}'``,``'['``,``']'`` 的字符串，判断字符串是否有效。
>
> 有效字符串需满足：
>
>  1. 左括号必须用相同类型的左括号闭合。
>  2. 左括号必须以正确的顺序闭合。
>
> 比如"()"、"()[]{}"、"{[]}" 都是有效字符串，而 "(]"、"([)]" 则不是。

**思路**

这问题实际时 Leetcode 的一道题目，我们可以利用栈 ``Stack`` 来解决这个文集。

1. 首先我们将括号间的对应规则存放在 ``Map`` 中
2. 创建一个栈。遍历字符串，如果字符是左括号就直接加入 ``Stack`` 中，否则将 ``Stack`` 的栈顶元素与这个括号做比较，如果不相等就直接返回 false。遍历结束，如果 ``Stack`` 为空，返回 ``true``。

```java
public boolean isValid(String s){
    //括号之间的对应规则
    HashMap<Character,Character> mappings = new HashMap<Character,Character>();
    mappings.put(')', '(');
    mappings.put('}', '{');
    mappings.put(']', '[');
    Stack<Character> stack = new Stack<Character>();
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
        if (mappings.containsKey(chars[i])) {
            char topElement = stack.empty() ? '#' : stack.pop();
            if (topElement != mappings.get(chars[i])) {
                return false;
            }
        } else {
            stack.push(chars[i]);
        }
    }
    return stack.isEmpty();
}
```

##### 3.2.3.反转字符串

将字符串中的每个字符先入栈再出栈就可以了。

##### 3.2.4.维护函数调用

最后一个被调用的函数必须先完成执行，符合栈的 **后进先出（LIFO,Last In First Out）** 特性。

#### 3.3.栈的实现

栈既可以通过数组实现，也可以通过链表来实现。不管基于数组还是链表，入栈、出栈的时间复杂度都为O(1)。

**使用数组实现栈**

具有``push()``、``pop()``(返回栈顶元素并出栈)、``peek()``(返回栈顶元素不出栈)、``isEmpty()``、``size()``这些基本的方法

> 提示：每次入栈之前先判断栈的容量是否够用，如果不够用就用``Arrays.copyOf()`` 进行扩容;

```java
public class MyStack {
    private int[] storage;//存放栈中元素的数组
    private int capacity;//栈的容量
    private int count;//栈中元素数量
    private static final int GROW_FACTOR = 2;

    //不带初始容量的构造方法。默认容量为8
    public MyStack() {
        this.capacity = 8;
        this.storage=new int[8];
        this.count = 0;
    }

    //带初始容量的构造方法
    public MyStack(int initialCapacity) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException("Capacity too small.");

        this.capacity = initialCapacity;
        this.storage = new int[initialCapacity];
        this.count = 0;
    }

    //入栈
    public void push(int value) {
        if (count == capacity) {
            ensureCapacity();
        }
        storage[count++] = value;
    }

    //确保容量大小
    private void ensureCapacity() {
        int newCapacity = capacity * GROW_FACTOR;
        storage = Arrays.copyOf(storage, newCapacity);
        capacity = newCapacity;
    }

    //返回栈顶元素并出栈
    private int pop() {
        if (count == 0)
            throw new IllegalArgumentException("Stack is empty.");
        count--;
        return storage[count];
    }

    //返回栈顶元素不出栈
    private int peek() {
        if (count == 0){
            throw new IllegalArgumentException("Stack is empty.");
        }else {
            return storage[count-1];
        }
    }

    //判断栈是否为空
    private boolean isEmpty() {
        return count == 0;
    }

    //返回栈中元素的个数
    private int size() {
        return count;
    }

}

```

**验证**

```java
MyStack myStack = new MyStack(3);
myStack.push(1);
myStack.push(2);
myStack.push(3);
myStack.push(4);
myStack.push(5);
myStack.push(6);
myStack.push(7);
myStack.push(8);
System.out.println(myStack.peek());//8
System.out.println(myStack.size());//8
for (int i = 0; i < 8; i++) {
    System.out.println(myStack.pop());
}
System.out.println(myStack.isEmpty());//true
myStack.pop();//报错：java.lang.IllegalArgumentException: Stack is empty.
```

### 4.队列

#### 4.1.队列简介

**队列（Queue）** 是 **先进先出（FIFO,First In,First Out)** 的线性表。再具体应用中常用链表或者数组来实现，用数组实现的队列叫作 **顺序队列**，用链表实现的队列叫做 **链式队列。队列只允许再后端（rear）进行插入操作也就是入队 enqueue，在前端（front）进行删除操作也就是出队 dequeue。**

队列的操作方式和堆栈类似，唯一的区别在于队列只允许新数据在后端进行添加。

> 假设队列中有 n 个元素
>
> 访问：O（n）//最坏情况
>
> 插入删除：O（1）//在后端插入前端删除元素

![queue](/docs/image/queue.png)

#### 4.2.队列分类

##### 4.2.1.单队列

单队列就是常见的队列，每次添加元素时，都是添加队尾。单队列又分为 **顺序队列（数组实现）**和 **链式队列（链表实现）**。

**顺序队列存在”假溢出“的问题也就是明明有位置却不能添加的情况。**

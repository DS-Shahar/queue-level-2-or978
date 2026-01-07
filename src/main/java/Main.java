class Main
{
    public static void main(String[]args)
    {
         // test sizes of character sequences
        Queue<Character> chars = new Queue<Character>();
        chars.insert('c');
        chars.insert('c');
        chars.insert('a');
        chars.insert('c');
        Queue<Integer> sizesResult = sizes(chars);
        System.out.println(sizesResult);

        // test repetition check
        Queue<String> strings = new Queue<String>();
        strings.insert("a");
        strings.insert("b");
        strings.insert("c");
        strings.insert("b");
        System.out.println(hasRepetitions(strings));

        // test clean duplicates
        Queue<Integer> nums = new Queue<Integer>();
        nums.insert(3);
        nums.insert(1);
        nums.insert(3);
        nums.insert(2);
        nums.insert(1);
        cleanDuplicates(nums);
        System.out.println(nums);

        // test sort queue
        Queue<Integer> unsorted = new Queue<Integer>();
        unsorted.insert(4);
        unsorted.insert(1);
        unsorted.insert(3);
        unsorted.insert(2);
        sortQueue(unsorted);
        System.out.println(unsorted);

        // test merge sorted queues
        Queue<Integer> q1 = new Queue<Integer>();
        q1.insert(1);
        q1.insert(3);
        q1.insert(5);

        Queue<Integer> q2 = new Queue<Integer>();
        q2.insert(2);
        q2.insert(4);
        q2.insert(6);

        Queue<Integer> merged = mergeSortedQueues(q1, q2);
        System.out.println(merged);

        // test longest even sequence sum
        Queue<Integer> evens = new Queue<Integer>();
        evens.insert(1);
        evens.insert(2);
        evens.insert(4);
        evens.insert(6);
        evens.insert(1);
        evens.insert(8);
        evens.insert(10);
        System.out.println(longestEvenSum(evens));
    }

//ex1 o(n)
public static Queue<Integer> sizes(Queue<Character> q)
    {
        Queue<Integer> result = new Queue<Integer>();
        if (q.isEmpty())
            return result;

        q.insert(null);
        Character prev = q.remove();
        int count = 1;
        Character curr = q.remove();

        while (curr != null)
        {
            if (curr.equals(prev))
            {
                count++;
            }
            else
            {
                result.insert(count);
                count = 1;
                prev = curr;
            }
            q.insert(curr);
            curr = q.remove();
        }

        result.insert(count);
        return result;
    }

//ex2(n*n)

public static <T> boolean isIn(Queue<T> q, T x)
{
    if (q.isEmpty())
        return false;

    q.insert(null);
    T temp = q.remove();

    while (temp != null)
    {
        if (temp.equals(x))
        {
            q.insert(temp);
            while (q.remove() != null);
            return true;
        }
        q.insert(temp);
        temp = q.remove();
    }
    return false;
}

public static boolean hasRepetitions(Queue<String> q)
{
    if (q.isEmpty())
        return false;

    q.insert(null);
    String curr = q.remove();

    while (curr != null)
    {
        if (isIn(q, curr))
        {
            q.insert(curr);
            while (q.remove() != null);
            return true;
        }
        q.insert(curr);
        curr = q.remove();
    }
    return false;
}

//ex3 o(n*n)
public static void cleanDuplicates(Queue<Integer> q)
{
    if (q.isEmpty())
        return;

    Queue<Integer> seen = new Queue<Integer>();

    q.insert(null);
    Integer x = q.remove();

    while (x != null)
    {
        if (!isIn(seen, x))
            seen.insert(x);
        x = q.remove();
    }

    seen.insert(null);
    Integer y = seen.remove();
    while (y != null)
    {
        q.insert(y);
        y = seen.remove();
    }
}

//ex4 o(n*n)
public static void sortQueue(Queue<Integer> q)
{
    Queue<Integer> q1 = new Queue<Integer>();
    Queue<Integer> q2 = new Queue<Integer>();

    while (!q.isEmpty())
    {
        int min = q.remove();

        while (!q.isEmpty())
        {
            int x = q.remove();
            if (x < min)
            {
                q1.insert(min);
                min = x;
            }
            else
                q1.insert(x);
        }

        q2.insert(min);

        while (!q1.isEmpty())
            q.insert(q1.remove());
    }

    while (!q2.isEmpty())
        q.insert(q2.remove());
}

//ex5 
public static Queue<Integer> mergeSortedQueues(Queue<Integer> q1, Queue<Integer> q2)
{
    Queue<Integer> result = new Queue<Integer>();

    while (!q1.isEmpty() && !q2.isEmpty())
    {
        if (q1.head() <= q2.head())
            result.insert(q1.remove());
        else
            result.insert(q2.remove());
    }

    while (!q1.isEmpty())
        result.insert(q1.remove());

    while (!q2.isEmpty())
        result.insert(q2.remove());

    return result;
}

//ex6 o(n)
public static int longestEvenSum(Queue<Integer> q)
{
    if (q.isEmpty())
        return 0;

    q.insert(null);

    int maxLen = 0;
    int maxSum = 0;

    int currLen = 0;
    int currSum = 0;

    Integer x = q.remove();

    while (x != null)
    {
        if (x % 2 == 0)
        {
            currLen++;
            currSum += x;
        }
        else
        {
            if (currLen > maxLen)
            {
                maxLen = currLen;
                maxSum = currSum;
            }
            currLen = 0;
            currSum = 0;
        }

        q.insert(x);
        x = q.remove();
    }

    if (currLen > maxLen)
        maxSum = currSum;

    return maxSum;
}
//stack reverse and queue reverse
        public static void stackreverse(Stack<Integer> s)
    {
        Queue<Integer> q =new Queue<Integer>();
        
        while (!s.isEmpty()) q.insert(s.pop());    

        while (!q.isEmpty()) s.push(q.remove());

    }

    public static void queuereverse(Queue<Integer> q)
    {
        Stack<Integer> s =new Stack<Integer>();
        
        while (!q.isEmpty()) s.push(q.remove());    

        while (!s.isEmpty()) q.insert(s.pop());

    }

}



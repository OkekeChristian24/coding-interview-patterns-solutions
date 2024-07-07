package javacode;

import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

class Element {
    int value;
    int frequency;
    int sequenceNumber;

    public Element(int value, int frequency, int sequenceNumber) {
        this.value = value;
        this.frequency = frequency;
        this.sequenceNumber = sequenceNumber;
    }
}

class ElementComparator implements Comparator<Element> {
    public int compare(Element e1, Element e2) {
        if (e1.frequency != e2.frequency)
            return e2.frequency - e1.frequency;
        return e2.sequenceNumber - e1.sequenceNumber;
    }
}

public class FrequencyStack {
    int sequenceCounter = 0;
    Map<Integer, Integer> numFreqMap = new HashMap<>();
    PriorityQueue<Element> maxHeap = new PriorityQueue<Element>(new ElementComparator());
    // PriorityQueue<Element> maxHeap = new PriorityQueue<Element>((e1, e2) -> {
    // if (e1.frequency != e2.frequency)
    // return e2.frequency - e1.frequency;
    // return e2.sequenceNumber - e1.sequenceNumber;
    // });

    public void push(int num) {
        numFreqMap.put(num, numFreqMap.getOrDefault(num, 0) + 1);
        maxHeap.offer(new Element(num, numFreqMap.get(num), sequenceCounter++));
    }

    public int pop() {
        int value = maxHeap.poll().value;
        numFreqMap.put(value, numFreqMap.get(value) - 1);
        if (numFreqMap.get(value) == 0)
            numFreqMap.remove(value);

        return value;
    }

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);

        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }
}

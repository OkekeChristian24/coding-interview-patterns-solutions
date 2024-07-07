import java.util.PriorityQueue;
import java.util.ArrayList;

class MatrixEntity {
    int outerIndex;
    int innerIndex;

    public MatrixEntity(int outerIndex, int innerIndex){
        this.outerIndex = outerIndex;
        this.innerIndex = innerIndex;
    }
}
class KthSmallestInSortedMatrix {

    public static int findKthSmallest(int[][] matrix, int k){
        PriorityQueue<MatrixEntity> minHeap = new PriorityQueue<>((a, b) -> matrix[a.outerIndex][a.innerIndex] - matrix[b.outerIndex][b.innerIndex]);
        for(int i = 0; i < matrix.length; i++){
            minHeap.add(new MatrixEntity(i, 0));
        }

        int result = 0;
        while(!minHeap.isEmpty() && k != 0){
            MatrixEntity me = minHeap.poll();
            result = matrix[me.outerIndex][me.innerIndex];
            if(me.innerIndex + 1 < matrix[me.outerIndex].length){
                minHeap.add(new MatrixEntity(me.outerIndex, me.innerIndex + 1));
            }
            k--;

        }

        return result;

    }

    public static void main(String[] args){

        int[][] matrix = {{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};
        int k = 3;
        System.out.println(k + "th smallest number is " + findKthSmallest(matrix, k));

    }
}
/**
 *
 * @author David Torres
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int temp = 0;
        int[] original = new int[10];
        int[] copy1 = new int[10];
        int[] copy2 = new int[10];
        int[] copy3 = new int[10];
        int[] copy4 = new int[10];
        int[] copy5 = new int[10];
        for (int i = 0; i < 10; i++) {
                temp = (int)(Math.random()*(int)(10*1.5)+1);        
                original[i] = temp;
                copy1[i] = temp;
                copy2[i] = temp;
                copy3[i] = temp;
                copy4[i] = temp;
                copy5[i] = temp;
        }
        System.out.println("Quick Sort");
        imprimir(original);
        quickSort(original);
        imprimir(original);
        
        System.out.println("");
        
        System.out.println("Bubble Sort");
        imprimir(copy1);
        bubble(copy1);
        imprimir(copy1);
        
        System.out.println("");
        
        System.out.println("Insertion Sort");
        imprimir(copy2);
        insertionSort(copy2);
        imprimir(copy2);
        
        System.out.println("");
        
        System.out.println("Selection Sort");
        imprimir(copy3);
        selectionSort(copy3);
        imprimir(copy3);
     
    }
    
    public static void imprimir(int[] arr){
        for (int i : arr) {
            System.out.print(i + " - ");
        }
        System.out.println("");
    }
        public static void quickSort(int[] arr, int min, int max){
        int izq = min;
        int pivote = arr[min];
        int der = max;
        while(izq < der){
            while(arr[izq] <= pivote && izq < der){
                izq++;
            }
            while(arr[der] > pivote){
                der--;
            }
            if(izq < der){
                int temp = arr[izq];
                arr[izq] = arr[der];
                arr[der] = temp;
            }
        }
        arr[min] = arr[der];
        arr[der] = pivote;
        if(min < der - 1){
            quickSort(arr, min, der-1);
        }
        if(der + 1 < max){
            quickSort(arr,der + 1, max);
        }
    }          
        
    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }
    
    public static void bubble(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                int temp = arr[j+1];
                if(arr[j] > arr[j+1]){
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
        public static void insertionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
        
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }        
    
    private static int binary(int[] arr, int x, int min, int max){
        int medio = min + ((max - min) / 2);
        int pos = -1;
        if(min <= max){
            if(x == arr[medio]){
                pos = medio;
            }
            else if(x < arr[medio]){
                pos = binary(arr, x, min, medio - 1);
            }
            else if(x > arr[medio]){
                pos = binary(arr, x, medio + 1, max);
            }
        }
        return pos;
    }
    
    public static int binarySearch(int[] arr, int pos){
        return binary(arr, pos, 0, arr.length-1);
    }
    
    public static int sequential(int[] arr, int x){
        int pos = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == x)
                pos = i;
                break;
        }
        return pos;
    }
}

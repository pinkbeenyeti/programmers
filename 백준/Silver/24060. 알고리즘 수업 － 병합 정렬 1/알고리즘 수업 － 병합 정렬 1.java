import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] array, tmp;
    private static int N, K, count = 0, answer = -1;

    private static void merge_sort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            merge_sort(arr, l, mid);
            merge_sort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int i = l, j = mid + 1, t = 1;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) tmp[t++] = arr[i++];
            else tmp[t++] = array[j++];
        }

        while (i <= mid) {
            tmp[t++] = array[i++];
        }

        while (j <= r) {
            tmp[t++] = array[j++];
        }

        i = l;
        t = 1;

        while (i <= r) {
            if (++count == K) answer = tmp[t];
            array[i++] = tmp[t++];
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[N];
        tmp = new int[N + 1];

        for (int i=0; i<N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void process() {
        merge_sort(array, 0, N - 1);
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}

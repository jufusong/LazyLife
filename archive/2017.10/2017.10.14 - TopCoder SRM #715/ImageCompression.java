package main;

public class ImageCompression {
    public String isPossible(String[] image, int K) {
        int n = image.length, m = image[0].length();
        for (int i = 0; i < n; i += K) {
            for (int j = 0; j < m; j += K) {
                int sum = 0;
                for (int k = i; k < i + K; k++) {
                    for (int h = j; h < j + K; h++) {
                        sum += image[k].charAt(h) - '0';
                    }
                }
                if (sum != 0 && sum != K * K) {
                    return "Impossible";
                }
            }
        }
        return "Possible";
    }
}

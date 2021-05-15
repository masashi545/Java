// 入出力処理について

import java.io.*; // java.ioライブラリ直下の全てのライブラリをインポートする。

class Sample8 {
    public static void main(String[] args) { // args[i] = java Sample8 [0] [1] [2] ...

        System.out.println("文字列を入力してください。");

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = br.readLine();
            System.out.println(str + "が入力されました。");

        } catch (IOException e) {
            System.out.println("入出力エラーです。");
        }
    }
}

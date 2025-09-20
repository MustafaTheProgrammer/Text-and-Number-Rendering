class textandnumbers{
    public static String black = "\u001B[47m  ";
    public static String white = "\u001B[100m  ";
    public static int width = 60;
    public static int height = 24;
    public static String[] pixels = new String[width * height];
    public static int num = 0;

    //text
    public static int[][] I = {{1, 1, 1, 1, 1},
                               {0, 0, 1, 0, 0},
                               {0, 0, 1, 0, 0},
                               {0, 0, 1, 0, 0},
                               {1, 1, 1, 1, 1}};

    public static int[][] P = {{1, 1, 1, 1, 0},
                               {1, 0, 0, 0, 1},
                               {1, 1, 1, 1, 0},
                               {1, 0, 0, 0, 0},
                               {1, 0, 0, 0, 0}};

    public static int[][] Z = {{1, 1, 1, 1, 1},
                               {0, 0, 1, 1, 1},
                               {0, 0, 1, 0, 0},
                               {1, 1, 0, 0, 0},
                               {1, 1, 1, 1, 1}};

    public static int[][] A = {{0, 0, 1, 0, 0},
                               {0, 1, 0, 1, 0},
                               {0, 1, 1, 1, 0},
                               {1, 0, 0, 0, 1},
                               {1, 0, 0, 0, 1}};

    //numbers
    public static int[][] zero = {{0, 1, 1, 1, 0},
                                  {1, 0, 0, 0, 1},
                                  {1, 0, 0, 0, 1},
                                  {1, 0, 0, 0, 1},
                                  {0, 1, 1, 1, 0}};

    public static int[][] one = {{0, 0, 1, 0, 0},
                                 {0, 1, 1, 0, 0},
                                 {0, 0, 1, 0, 0},
                                 {0, 0, 1, 0, 0},
                                 {0, 1, 1, 1, 0}};

    public static int[][] two = {{0, 1, 1, 1, 0},
                                 {1, 0, 0, 0, 1},
                                 {0, 0, 1, 1, 0},
                                 {0, 1, 0, 0, 0},
                                 {1, 1, 1, 1, 1}};

    public static int[][] three = {{0, 1, 1, 1, 0},
                                   {0, 0, 0, 0, 1},
                                   {0, 1, 1, 1, 0},
                                   {0, 0, 0, 0, 1},
                                   {0, 1, 1, 1, 0}};

    public static void main(String[] args) throws InterruptedException{
        while (1==1){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
            for (int i = 0; i < pixels.length; i++){
                pixels[i] = white;
            }

            writeText("pizza", 0, -5);

            num++;
            if (num > 3){
                num = 0;
            }
            
            writeNumber(num, 0, -15);
            
            for (int i = 0; i < height; i++){
                for (int j = 0; j < width; j++){
                    System.out.print(pixels[i * width + j]);
                }
                System.out.println("\u001B[0m");
            }
            Thread.sleep(1000);
        }
    }

    static void setPixel(int x, int y, String color){
        pixels[Math.abs(y) * width + x] = color;
    }

    static void drawSprite(int[][] sprite, int x, int y){
        for (int i = y; i < y + sprite.length; i++){
            for (int j = x; j < x + sprite[0].length; j++){
                switch (sprite[Math.abs(i-(y+(sprite.length-1)))][j-x]){
                        case 1: setPixel(j, i, black);
                }
            }
        }
    }

    static void writeText(String text, int x, int y){
        for (int i = 0; i < text.length(); i++){
            switch (text.charAt(i)){
                    case 'p': drawSprite(P, x, y); x += 6;
                    break;
                    case 'i': drawSprite(I, x, y); x += 6;
                    break;
                    case 'z': drawSprite(Z, x, y); x += 6;
                    break;
                    case 'a': drawSprite(A, x, y); x += 6;
                    break;
            }
        }
    }

    static void writeNumber(int number, int x, int y){
        String text = Integer.toString(number);
        for (int i = 0; i < text.length(); i++){
            switch (text.charAt(i)){
                    case '0': drawSprite(zero, x, y); x += 6;
                    break;
                    case '1': drawSprite(one, x, y); x += 6;
                    break;
                    case '2': drawSprite(two, x, y); x += 6;
                    break;
                    case '3': drawSprite(three, x, y); x += 6;
                    break;
            }
        }
    }
}
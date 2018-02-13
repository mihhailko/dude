class Dude {

    public static void main(String[] args) {

        try {


            if (args[0].equals("explain")) {

                System.out.println("I shall explain " + args[1]);

                System.exit(0);

            }

            if (args[0].equals("learn")) {

                System.out.println("I shall learn " + args[1]);

                System.exit(0);

            }

            if (args[0].equals("help")) {

                System.out.print("-----DUDE-----\n" +
                        "----version 0.1.0-----\n" +
                        "usage: \n" +
                        "dude [function] [args] \n" +
                        "functions: \n" +
                        "\t learn \n" +
                        "\t explain \n");


            }



        } catch (Exception e) {

            System.out.println("please consult the manual");

            System.exit(0);


        }

    }

}
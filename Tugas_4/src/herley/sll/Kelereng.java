package herley.sll;

/**
 * @author herley
 */

public class Kelereng {
    public static int MERAH = 3;
    public static int HIJAU = 1;
    public static int BIRU = 2;
    public static int KUNING = 4;
    public static int JINGGA = 5;
    public static int UNGU = 6;
    public static int POLKADOT = 7;
    public static int AQUAMARINE = 8;
    public static int HITAM = 9;
    public static int PUTIH = 10;

    private  final  int warna;

    public Kelereng(int warna){
        this.warna = warna;
    }

    public int getWarna(){return this.warna;}

    public String toString(){
        final String[]warna = new String[11];
        warna[1] = "HIJAU";
        warna[2] = "BIRU";
        warna[3] = "MERAH";
        warna[4] = "KUNING";
        warna[5] = "JINGGA";
        warna[6] = "UNGU";
        warna[7] = "POLKADOT";
        warna[8] = "AQUAMARINE";
        warna[9] = "HITAM";
        warna[10] = "PUTIH";
        return warna[this.warna];
    }
}

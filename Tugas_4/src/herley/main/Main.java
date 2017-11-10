package herley.main;

import herley.sll.Kelereng;
import herley.sll.Node;
import herley.sll.SingleLinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author herley
 */

public class Main {
    public static void main(String[] args) {
        try{
            final InputStreamReader reader = new InputStreamReader(System.in);
            final BufferedReader jumlah = new BufferedReader(reader);
            int jumlahPerulangan = Integer.parseInt(jumlah.readLine());

            final String[] strings = new String[jumlahPerulangan];

            for (int i=0; i<jumlahPerulangan; i++){
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                strings[i] = bufferedReader.readLine();
            }

            final SingleLinkedList singleLinkedList = new SingleLinkedList();

            for (String string : strings) {
                final String[] split = string.split("\\s+");
                if(Integer.parseInt(split[1]) >= 1 && Integer.parseInt(split[1]) <= 10){
                    singleLinkedList.addNode(new Node<Kelereng>(new Kelereng(Integer.parseInt(split[1]))),Integer.parseInt(split[0]));
                }
            }

            System.out.println(singleLinkedList.getSkor());

        }catch (Exception e){
            e.printStackTrace();
        }

//        final Node<Kelereng> kelerengMerah = new Node(new Kelereng(Kelereng.MERAH));
//        final Node<Kelereng> kelerengBiru = new Node(new Kelereng(Kelereng.BIRU));
//        final Node<Kelereng> kelerengKuning = new Node(new Kelereng(Kelereng.KUNING));
//        final Node<Kelereng> kelerengHijau = new Node(new Kelereng(Kelereng.HIJAU));
//
//        final SingleLinkedList sll = new SingleLinkedList();
//        sll.addNode(new Node<Kelereng>(new Kelereng(Kelereng.MERAH)),0);
//        sll.addNode(new Node<Kelereng>(new Kelereng(Kelereng.HIJAU)),1);
//        sll.addNode(new Node<Kelereng>(new Kelereng(Kelereng.HIJAU)),2);
//        sll.addNode(new Node<Kelereng>(new Kelereng(Kelereng.HIJAU)),3);
//        sll.addNode(new Node<Kelereng>(new Kelereng(Kelereng.BIRU)),4);
//        sll.addNode(new Node<Kelereng>(new Kelereng(Kelereng.BIRU)),4);
//        sll.addNode(new Node<Kelereng>(new Kelereng(Kelereng.BIRU)),4);
//        sll.addNode(new Node<Kelereng>(new Kelereng(Kelereng.HIJAU)));
//        sll.addNode(new Node<Kelereng>(new Kelereng(Kelereng.HIJAU)));
//        sll.addNode(new Node<Kelereng>(new Kelereng(Kelereng.KUNING)));
//        sll.addNode(new Node<Kelereng>(new Kelereng(Kelereng.BIRU)),5);
//
//        Node pointer = sll.getRoot();
//        while (pointer != null){
//            System.out.println(pointer.getData()+" "+pointer.getIndex());
//            pointer = pointer.getNextNode();
//        }
//        System.out.println("Skor : "+sll.getSkor());
//        System.out.println("******************************");
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    class Hesap {
        double bakiye;
    }
    Hesap ana = new Hesap();

    ana.bakiye = 100;

    Hesap yedek = ana;
    yedek.bakiye = yedek.bakiye - 30;
    System.out.println(ana.bakiye);

    Hesap kopya = new Hesap();
    kopya.bakiye = ana.bakiye;
    kopya.bakiye = kopya.bakiye - 50;

    System.out.println(ana.bakiye);
    System.out.println(kopya.bakiye);


    Hesap bos = null;
    if (bos == null) {
        System.out.println("Hesap Yok");
    }

//Heapte 2 nesne var new ile oluşan yeni nesneler

}


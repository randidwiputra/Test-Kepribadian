
import com.sun.lwuit.Display;
import com.sun.lwuit.Calendar;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.Command;
import com.sun.lwuit.RadioButton;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.Calendar;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.Button;

import com.sun.lwuit.*;

import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;


import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.GridLayout;
import com.sun.lwuit.layouts.BoxLayout;


import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.plaf.Style;
import com.sun.lwuit.plaf.Border;

import com.sun.lwuit.util.Resources;

import java.io.IOException;

public class TesKepribadian extends javax.microedition.midlet.MIDlet implements ActionListener {

    int score = 0;
    private String scoreAnalisa = "";
    private String name;
    private String profilHome = "Beberapa orang membayar mahal untuk mengetahui hal ini.\n\n"
            + "Bacalah, ini sangat menarik! Jangan terlalu sensitif!\n\n"
            + "Tes berikut cukup akurat dan hanya membutuhkan waktu sekitar 2 menit.\n\n"
            + "Jawablah sebagaimana Anda adanya saat ini ... Bukan sebagaimana Anda yang lalu.\n\n"
            + "Siapkan diri Anda dan jujurlah pada diri sendiri.\n\n"
            + "Ini adalah tes sungguhan yang dipakai oleh HRD beberapa perusahaan besar saat ini.\n\n"
            + "Tes ini hanya terdiri 10 pertanyaan sederhana, maka bersegeralah.\n\n\n\n";
			
    private String analisaPengatur = "Orang lain melihat Anda sebagai seorang yang dapat \"menangani\"."
            + " Anda terlihat sombong, egois dan seorang yang sangat mendominasi."
            + " Orang lain mungkin mengagumi Anda, berharap mereka dapat lebih seperti Anda,"
            + "tetapi tidak selalu percaya pada Anda, dan ragu ragu untuk terlalu dekat dengan Anda.";
			
    private String analisaMotivator = "Orang lain melihat Anda sebagai seorang yang bersemangat, "
            + "mudah berubah pendirian, agak berkepribadian impulsive (menurutkan perasaan), "
            + "pemimpin berbakat, seorang yang cepat membuat keputusan, berfikir tidak hanya dari satu sisi, "
            + "mereka melihat Anda sebagai pemberani dan petualang, seseorang yang akan mencoba setiap sesuatu,"
            + "seseorang yang mengambil resiko dan suka petualangan. Mereka senang berada di perusahaan Anda karena kegembiraan Anda memancar.";
			
    private String analisaPenghibur = "Orang lain melihat Anda sebagai seorang yang segar, hidup, mempesona, lucu, praktis dan selalu menarik "
            + "seseorang yang secara konstan dalam pusat perhatian, tetapi cukup seimbang tidak menjadikanya besar kepala."
            + "Mereka juga melihat Anda seorang yang baik, penuh perhatian, dan mengerti; seseorang yang akan selalu menghibur dan membantu mereka.";
			
    private String analisaBijak = "Orang lain melihat Anda sebagai seorang yang bijaksana, perhatian, hati-hati, dan praktis."
            + "Mereka melihat Anda cerdas, berbakat, tetapi rendah hati. Bukan seorang yang terlalu cepat "
            + "atau mudah membuat jalinan pertemanan, tetapi dia adalah seseorang yang sangat setia pada pertemanan yang dijalani "
            + "dan seseorang yang mengharap kesetiaan itu dibalas. Itulah yang membuat tahu siapa sesungguhnya Anda, "
            + "orang tahu hal ini dapat sangat menggoyahkan kepercayaan Anda pada teman Anda, "
            + "dan sama halnya juga akan membutuhkan waktu lama untuk meyakinkan jika kepercayaan Anda pernah dikhianati.\n\n";
			
    private String analisaPerfect = "Orang lain melihat mu sebagai seorang yang serius dan cerewet. "
            + "Mereka melihat Anda sebagai seorang yang sangat perhatian, sangat hati-hati, pelan dan tetap tekun. "
            + "Akan sangat mengagetkan mereka jika Anda pernah melakukan sesuatu secara impulsive (menurutkan perasaan) atau tersemangati beberapa saat, "
            + "mengharapkan Anda untuk memeriksa setiap sesuatu dengan hati-hati dari setiap sudut dan kemudian biasanya memutuskannya. "
            + "Mereka pikir reaksi ini disebabkan oleh bagian dari sifat kehati-hatian Anda.";
			
    private String analisaPencemas = "Orang mengira Anda pemalu, penakut, ragu-ragu, seorang yang membutuhkan penjagaan, "
            + "yang selalu ingin orang lain yang membuat keputusan dan yang tidak ingin dilibatkan dengan seseorang atau sesuatu! "
            + "Mereka melihat Anda sebagai seorang yang cemas yang selalu melihat masalah padahal tidak ada. "
            + "Beberapa orang mengira Anda sedang bosan. Hanya beberapa orang yang tahu bahwa Anda sebenarnya tidak begitu.";
			
    private String pertanyaanSatu = "1. Kapan Anda merasa sangat baik?";
	
    private String pertanyaanDua = "2. Anda biasanya berjalan...";

    // Method startApp awal tampilan
    public void startApp() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));

            Form form = new Form();

            form.addCommand(new Command("Masuk", 0));
            form.addCommand(new Command("Keluar", 5));

            form.addCommand(new Command("Java  Theme", 1));
            form.addCommand(new Command("Star  Theme", 2));
            form.addCommand(new Command("LWUIT Theme", 3));
            form.addCommand(new Command("Busin Theme", 4));
            form.setCommandListener(this);

            form.setTitle("- Test ini merupakan test personality dan tak ada hubungannya dengan intelegensi dan kreatifitas anda -");
            form.setLayout(new BorderLayout());
            Label image = new Label(Image.createImage("/logo.png"));
            image.setAlignment(Label.CENTER);
            form.addComponent(BorderLayout.NORTH, image);
            form.show();
        } catch (Exception e) {
        }

    }	// akhir method startApp

    public void actionPerformed(ActionEvent ae) {
        Command cmd = ae.getCommand();

        switch (cmd.getId()) {
            case 0:
                getHome();
                break;
            case 1:
                setTheme("/javaTheme.res");
                break;
            case 2:
                setTheme("/starTheme.res");
                break;
            case 3:
                setTheme("/LWUITtheme.res");
                break;
            case 4:
                setTheme("/businessTheme.res");
                break;
            case 5:
                notifyDestroyed();
                break;
        }	// end switch		
    }	// end actionPerformed

    public void tampilan() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/starTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));

            Form f = new Form();
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            Label spasi = new Label();
            Label a = new Label("");
            a.setAlignment(Label.CENTER);

            Button tombol1 = new Button("Test Kepribadian");
            tombol1.getStyle().setBorder(Border.createEtchedRaised());
            tombol1.getStyle().setBgTransparency(100);
            tombol1.getStyle().setMargin(3, 3, 50, 50);

            tombol1.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    getSoalSatu();
                }
            });

            Button tombol2 = new Button("Analisa Kepribadian");
            tombol2.getStyle().setBorder(Border.createEtchedRaised());
            tombol2.getStyle().setBgTransparency(100);
            tombol2.getStyle().setMargin(3, 3, 50, 50);

            tombol2.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    getAnalisa();
                }
            });

            Button tombol3 = new Button("Themes");
            tombol3.getStyle().setBorder(Border.createEtchedRaised());
            tombol3.getStyle().setBgTransparency(100);
            tombol3.getStyle().setMargin(3, 3, 50, 50);

            tombol3.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    getPengaturanTema();
                }
            });

            Button tombol4 = new Button("Petunjuk");
            tombol4.getStyle().setBorder(Border.createEtchedRaised());
            tombol4.getStyle().setBgTransparency(100);
            tombol4.getStyle().setMargin(3, 3, 50, 50);

            tombol4.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    getPetunjuk();

                }
            });

            f.setTitle(".:: Test Kepribadian Dr.Phil ::.");
            f.addComponent(spasi);
            f.addComponent(a);
            f.addComponent(tombol1);
            f.addComponent(tombol2);
            f.addComponent(tombol3);
            f.addComponent(tombol4);

            f.addCommand(new Command("Kembali") {

                
                public void actionPerformed(ActionEvent ae) {
                    getHome();
                }
            });


            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error [1], gambar tidak ditemukan " + ie.toString());
        }
    }  // akhir method tampilan

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    private void setTheme(String name) {
        try {
            this.name = name;
            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Display.getInstance().getCurrent().refreshTheme();
        } catch (java.io.IOException err) {
            err.printStackTrace();
        }

    }	// akhir method setTheme

    public String getTheme() {
        return name;
    }

    public void getSoalSatu() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
            TextArea area = new TextArea(pertanyaanSatu);
            Label spasi = new Label("");


            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            Button a = new Button("a). Pagi hari");
            a.getStyle().setBorder(Border.createEtchedRaised());
            a.getStyle().setBgTransparency(100);
            a.getStyle().setMargin(3, 3, 20, 20);
            a.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score = 2;
                    getSoalDua();

                }
            });

            Button b = new Button("b). Sepanjang sore sampai petang");
            b.getStyle().setBorder(Border.createEtchedRaised());
            b.getStyle().setBgTransparency(100);
            b.getStyle().setMargin(3, 3, 20, 20);
            b.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score = 4;
                    getSoalDua();
                }
            });

            Button c = new Button("c). Larut Malam");
            c.getStyle().setBorder(Border.createEtchedRaised());
            c.getStyle().setBgTransparency(100);
            c.getStyle().setMargin(3, 3, 20, 20);
            c.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score = 6;
                    getSoalDua();
                }
            });

            f.addComponent(area);
            f.addComponent(spasi);

            f.addComponent(a);
            f.addComponent(b);
            f.addComponent(c);
            f.setTitle(".:: Test Dr.Phil ::.");
            f.addCommand(new Command("Kembali") {
                 public void actionPerformed(ActionEvent ae) {
                  tampilan();
                }
            });
          
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getSoalDua() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
            TextArea area = new TextArea(pertanyaanDua);
            Label spasi = new Label("");


            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            Button a = new Button("a). agak cepat dengan langkah panjang");
            a.getStyle().setBorder(Border.createEtchedRaised());
            a.getStyle().setBgTransparency(100);
            // a.getStyle().setMargin(3, 3, 10, 10);
            a.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 6;
                    getSoalTiga();

                }
            });

            Button b = new Button("b). agak cepat, dengan langkah pendek");
            b.getStyle().setBorder(Border.createEtchedRaised());
            b.getStyle().setBgTransparency(100);

            b.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 4;
                    getSoalTiga();
                }
            });

            Button c = new Button("c). sedikit cepat, tegap, menatap bumi di hadapan");
            c.getStyle().setBorder(Border.createEtchedRaised());
            c.getStyle().setBgTransparency(100);
            c.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 7;
                    getSoalTiga();
                }
            });

            Button d = new Button("d). sedikit cepat, menunduk");
            d.getStyle().setBorder(Border.createEtchedRaised());
            d.getStyle().setBgTransparency(100);

            d.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 2;
                    getSoalTiga();
                }
            });

            Button e = new Button("e). sangat lambat");
            e.getStyle().setBorder(Border.createEtchedRaised());
            e.getStyle().setBgTransparency(100);

            e.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 1;
                    getSoalTiga();
                }
            });

            f.addComponent(area);
            f.addComponent(spasi);

            f.addComponent(a);
            f.addComponent(b);
            f.addComponent(c);
            f.addComponent(d);
            f.addComponent(e);
            f.setTitle(".:: Test Dr.Phil ::.");
            f.addCommand(new Command("Kembali") {
                public void actionPerformed(ActionEvent ae) {
                    tampilan();
                }
            });
           
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getSoalTiga() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
            String soalTiga = "3. Ketika berbicara dengan orang, Anda…";
            TextArea area = new TextArea(soalTiga);
            Label spasi = new Label("");


            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            Button a = new Button("a). berdiri dengan lengan berlipat");
            a.getStyle().setBorder(Border.createEtchedRaised());
            a.getStyle().setBgTransparency(100);

            a.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 4;
                    getSoalEmpat();

                }
            });

            Button b = new Button("b). kedua tangan Anda berpegangan");
            b.getStyle().setBorder(Border.createEtchedRaised());
            b.getStyle().setBgTransparency(100);

            b.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 2;
                    getSoalEmpat();
                }
            });

            Button c = new Button("c). salah satu atau kedua tangan Anda di pinggul atau masuk kantong");
            c.getStyle().setBorder(Border.createEtchedRaised());
            c.getStyle().setBgTransparency(100);
            c.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 5;
                    getSoalEmpat();
                }
            });

            Button d = new Button("d). menyentuh atau mendorong lawan bicara");
            d.getStyle().setBorder(Border.createEtchedRaised());
            d.getStyle().setBgTransparency(100);

            d.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 7;
                    getSoalEmpat();
                }
            });

            Button e = new Button("e). memainkan telinga, menyentuh dagu atau mengelus rambut kepala ");
            e.getStyle().setBorder(Border.createEtchedRaised());
            e.getStyle().setBgTransparency(100);

            e.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 6;
                    getSoalEmpat();
                }
            });

            f.addComponent(area);
            f.addComponent(spasi);

            f.addComponent(a);
            f.addComponent(b);
            f.addComponent(c);
            f.addComponent(d);
            f.addComponent(e);
            f.setTitle(".:: Test Dr.Phil ::.");
            f.addCommand(new Command("Kembali") {
                public void actionPerformed(ActionEvent ae) {
                         tampilan();
                }
            });
           
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getSoalEmpat() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
            String soalEmpat = "4. Ketika santai, Anda duduk dengan…";
            TextArea area = new TextArea(soalEmpat);
            Label spasi = new Label("");


            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            Button a = new Button("a). Kedua lutut bengkok dengan kaki berdampingan rapih");
            a.getStyle().setBorder(Border.createEtchedRaised());
            a.getStyle().setBgTransparency(100);

            a.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 4;
                    getSoalLima();

                }
            });

            Button b = new Button("b). kedua kaki Anda menyilang");
            b.getStyle().setBorder(Border.createEtchedRaised());
            b.getStyle().setBgTransparency(100);

            b.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 6;
                    getSoalLima();
                }
            });

            Button c = new Button("c). kedua kaki terjulur atau lurus");
            c.getStyle().setBorder(Border.createEtchedRaised());
            c.getStyle().setBgTransparency(100);
            c.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 2;
                    getSoalLima();
                }
            });

            Button d = new Button("d). salah satu kaki Anda diduduki");
            d.getStyle().setBorder(Border.createEtchedRaised());
            d.getStyle().setBgTransparency(100);

            d.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 1;
                    getSoalLima();
                }
            });


            f.addComponent(area);
            f.addComponent(spasi);

            f.addComponent(a);
            f.addComponent(b);
            f.addComponent(c);
            f.addComponent(d);

            f.setTitle(".:: Test Dr.Phil ::.");
            f.addCommand(new Command("Kembali") {
                public void actionPerformed(ActionEvent ae) {
                   tampilan();
                }
            });
           
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getSoalLima() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
            String soalLima = "5. Ketika sesuatu benar-benar membuat Anda geli, Anda bereaksi dengan…";
            TextArea area = new TextArea(soalLima);
            Label spasi = new Label("");


            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            Button a = new Button("a). tertawa keras");
            a.getStyle().setBorder(Border.createEtchedRaised());
            a.getStyle().setBgTransparency(100);

            a.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 6;
                    getSoalEnam();

                }
            });

            Button b = new Button("b). tertawa, tapi tidak keras ");
            b.getStyle().setBorder(Border.createEtchedRaised());
            b.getStyle().setBgTransparency(100);

            b.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 4;
                    getSoalEnam();
                }
            });

            Button c = new Button("c). tertawa-tawa kecil");
            c.getStyle().setBorder(Border.createEtchedRaised());
            c.getStyle().setBgTransparency(100);
            c.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 3;
                    getSoalEnam();
                }
            });

            Button d = new Button("d). tersenyum malu");
            d.getStyle().setBorder(Border.createEtchedRaised());
            d.getStyle().setBgTransparency(100);

            d.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 5;
                    getSoalEnam();
                }
            });

            Button e = new Button("e). tidak bereaksi");
            e.getStyle().setBorder(Border.createEtchedRaised());
            e.getStyle().setBgTransparency(100);

            e.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 2;
                    getSoalEnam();
                }
            });

            f.addComponent(area);
            f.addComponent(spasi);

            f.addComponent(a);
            f.addComponent(b);
            f.addComponent(c);
            f.addComponent(d);
            f.addComponent(e);
            f.setTitle(".:: Test Dr.Phil ::.");
            f.addCommand(new Command("Kembali") {
                public void actionPerformed(ActionEvent ae) {
                  tampilan();
                }
            });
           
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getSoalEnam() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
            String soalEnam = "6. Ketika Anda pergi ke pesta atau pertemuan ramah-tamah, Anda…";
            TextArea area = new TextArea(soalEnam);
            Label spasi = new Label("");


            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            Button a = new Button("a). masuk dengan terbuka sehingga setiap orang memperhatikan Anda");
            a.getStyle().setBorder(Border.createEtchedRaised());
            a.getStyle().setBgTransparency(100);

            a.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 6;
                    getSoalTujuh();

                }
            });

            Button b = new Button("b). masuk pelan-pelan, sambil melihat-lihat orang yang Anda kenal");
            b.getStyle().setBorder(Border.createEtchedRaised());
            b.getStyle().setBgTransparency(100);

            b.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 4;
                    getSoalTujuh();
                }
            });

            Button c = new Button("c). masuk diam-diam, mencoba untuk tidak diketahui");
            c.getStyle().setBorder(Border.createEtchedRaised());
            c.getStyle().setBgTransparency(100);
            c.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 2;
                    getSoalTujuh();
                }
            });


            f.addComponent(area);
            f.addComponent(spasi);

            f.addComponent(a);
            f.addComponent(b);
            f.addComponent(c);

            f.setTitle(".:: Test Dr.Phil ::.");
            f.addCommand(new Command("Kembali") {
                   public void actionPerformed(ActionEvent ae) {
                       tampilan();
                }
            });
           
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getSoalTujuh() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
            String soalTujuh = "7. Ketika Anda bekerja atau sedang amat berkonsentrasi, kemudian Anda diinterupsi, maka Anda…";
            TextArea area = new TextArea(soalTujuh);
            Label spasi = new Label("");


            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            Button a = new Button("a). menyambut (beristirahat)");
            a.getStyle().setBorder(Border.createEtchedRaised());
            a.getStyle().setBgTransparency(100);

            a.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 6;
                    getSoalDelapan();

                }
            });

            Button b = new Button("b). merasa sangat terganggu");
            b.getStyle().setBorder(Border.createEtchedRaised());
            b.getStyle().setBgTransparency(100);

            b.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 2;
                    getSoalDelapan();
                }
            });

            Button c = new Button("c). berubah-ubah di antara dua kemungkinan di atas");
            c.getStyle().setBorder(Border.createEtchedRaised());
            c.getStyle().setBgTransparency(100);
            c.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 4;
                    getSoalDelapan();
                }
            });


            f.addComponent(area);
            f.addComponent(spasi);

            f.addComponent(a);
            f.addComponent(b);
            f.addComponent(c);

            f.setTitle(".:: Test Dr.Phil ::.");
            f.addCommand(new Command("Kembali") {
                public void actionPerformed(ActionEvent ae) {
                 tampilan();
                }
            });
            
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getSoalDelapan() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form form = new Form();
            String soalDelapan = "8. Mana di antara warna berikut yang paling Anda sukai?";
            TextArea area = new TextArea(soalDelapan);
            Label spasi = new Label("");


            area.setEditable(false);
            form.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            Button a = new Button("a). Merah atau orange");
            a.getStyle().setBorder(Border.createEtchedRaised());
            a.getStyle().setBgTransparency(100);

            a.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 6;
                    getSoalSembilan();

                }
            });

            Button b = new Button("b). Hitam");
            b.getStyle().setBorder(Border.createEtchedRaised());
            b.getStyle().setBgTransparency(100);

            b.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 7;
                    getSoalSembilan();
                }
            });

            Button c = new Button("c). Kuning atau biru langit");
            c.getStyle().setBorder(Border.createEtchedRaised());
            c.getStyle().setBgTransparency(100);
            c.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 5;
                    getSoalSembilan();
                }
            });

            Button d = new Button("d). Hijau");
            d.getStyle().setBorder(Border.createEtchedRaised());
            d.getStyle().setBgTransparency(100);

            d.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 4;
                    getSoalSembilan();
                }
            });

            Button e = new Button("e). Biru gelap atau ungu");
            e.getStyle().setBorder(Border.createEtchedRaised());
            e.getStyle().setBgTransparency(100);

            e.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 3;
                    getSoalSembilan();
                }
            });

            Button f = new Button("f). Putih");
            f.getStyle().setBorder(Border.createEtchedRaised());
            f.getStyle().setBgTransparency(100);

            f.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 2;
                    getSoalSembilan();
                }
            });

            Button g = new Button("g). Coklat atau Abu abu");
            g.getStyle().setBorder(Border.createEtchedRaised());
            g.getStyle().setBgTransparency(100);

            g.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 1;
                    getSoalSembilan();
                }
            });

            form.addComponent(area);
            form.addComponent(spasi);

            form.addComponent(a);
            form.addComponent(b);
            form.addComponent(c);
            form.addComponent(d);
            form.addComponent(e);
            form.addComponent(f);
            form.addComponent(g);
            form.setTitle(".:: Test Dr.Phil ::.");
            form.addCommand(new Command("Kembali") {
				public void actionPerformed(ActionEvent ae) {
                     tampilan();
                }
            });
           
            form.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getSoalSembilan() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
            String soalSembilan = "9. Ketika Anda tidur malam hari, beberapa saat sebelum tidur, Anda…";
            TextArea area = new TextArea(soalSembilan);
            Label spasi = new Label("");


            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            Button a = new Button("a). berbaring terlentang");
            a.getStyle().setBorder(Border.createEtchedRaised());
            a.getStyle().setBgTransparency(100);

            a.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 7;
                    getSoalSepuluh();

                }
            });

            Button b = new Button("b). berbaring telungkup");
            b.getStyle().setBorder(Border.createEtchedRaised());
            b.getStyle().setBgTransparency(100);

            b.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 6;
                    getSoalSepuluh();
                }
            });

            Button c = new Button("c). ke samping, sedikit melengkung");
            c.getStyle().setBorder(Border.createEtchedRaised());
            c.getStyle().setBgTransparency(100);
            c.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 4;
                    getSoalSepuluh();
                }
            });

            Button d = new Button("d). dengan kepala menindih tangan");
            d.getStyle().setBorder(Border.createEtchedRaised());
            d.getStyle().setBgTransparency(100);

            d.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 2;
                    getSoalSepuluh();
                }
            });

            Button e = new Button("e). dengan kepala dibawah selimut");
            e.getStyle().setBorder(Border.createEtchedRaised());
            e.getStyle().setBgTransparency(100);

            e.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 1;
                    getSoalSepuluh();
                }
            });

            f.addComponent(area);
            f.addComponent(spasi);

            f.addComponent(a);
            f.addComponent(b);
            f.addComponent(c);
            f.addComponent(d);
            f.addComponent(e);
            f.setTitle(".:: Test Dr.Phil ::.");
            f.addCommand(new Command("Kembali") {
                 public void actionPerformed(ActionEvent ae) {
					tampilan();
                }
            });
           
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getSoalSepuluh() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form form = new Form();
            String soalSepuluh = "10. Anda sering memimpikan diri Anda…";
            TextArea area = new TextArea(soalSepuluh);
            Label spasi = new Label("");


            area.setEditable(false);
            form.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            Button a = new Button("a). jatuh");
            a.getStyle().setBorder(Border.createEtchedRaised());
            a.getStyle().setBgTransparency(100);

            a.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 4;
                    getHasilAnalisa();

                }
            });

            Button b = new Button("b). bertarung atau berjuang");
            b.getStyle().setBorder(Border.createEtchedRaised());
            b.getStyle().setBgTransparency(100);

            b.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 2;
                    getHasilAnalisa();
                }
            });

            Button c = new Button("c). mencari sesuatu atau seseorang");
            c.getStyle().setBorder(Border.createEtchedRaised());
            c.getStyle().setBgTransparency(100);
            c.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 3;
                    getHasilAnalisa();
                }
            });

            Button d = new Button("d). terbang atau terapung");
            d.getStyle().setBorder(Border.createEtchedRaised());
            d.getStyle().setBgTransparency(100);

            d.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 5;
                    getHasilAnalisa();
                }
            });

            Button e = new Button("e). Anda biasanya tidur tanpa mimpi");
            e.getStyle().setBorder(Border.createEtchedRaised());
            e.getStyle().setBgTransparency(100);

            e.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 6;
                    getHasilAnalisa();
                }
            });

            Button f = new Button("f). mimpi Anda selalu menyenangkan");
            f.getStyle().setBorder(Border.createEtchedRaised());
            f.getStyle().setBgTransparency(100);

            f.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    score += 1;
                    getHasilAnalisa();
                }
            });

            form.addComponent(area);
            form.addComponent(spasi);

            form.addComponent(a);
            form.addComponent(b);
            form.addComponent(c);
            form.addComponent(d);
            form.addComponent(e);
            form.addComponent(f);
            form.setTitle(".:: Test Dr.Phil ::.");
            form.addCommand(new Command("Kembali") {
                 public void actionPerformed(ActionEvent ae) {
                    tampilan();
                }
            });
            
            form.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getHasilAnalisa() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
            TextArea area = new TextArea(profilHome, 10, 10);

            if (score > 60) {
                area = new TextArea(analisaPengatur, 10, 10);
                scoreAnalisa = "Pengatur";
            } else if (score == 51 && score <= 60) {
                area = new TextArea(analisaMotivator, 10, 10);
                scoreAnalisa = "MOTIVATOR";
            } else if (score == 41 && score <= 50) {
                area = new TextArea(analisaPenghibur, 10, 10);
                scoreAnalisa = "PENGHIBUR";
            } else if (score == 31 && score <= 40) {
                area = new TextArea(analisaBijak, 10, 10);
                scoreAnalisa = "BIJAK";
            } else if (score == 21 && score <= 30) {
                area = new TextArea(analisaPerfect, 10, 10);
                scoreAnalisa = "PERFECT";
            } else if (score < 21) {
                area = new TextArea(analisaPencemas, 10, 10);
                scoreAnalisa = "PENCEMAS";
            }
            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            f.addComponent(area);
            f.setTitle("SCORE Anda: " + score + " = " + scoreAnalisa);
            f.addCommand(new Command("Kembali") {
                 public void actionPerformed(ActionEvent ae) {
                    startApp();
                }
            });
           
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getHome() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
            TextArea area = new TextArea(profilHome, 10, 10);
            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            f.addComponent(area);
            f.setTitle(".:: Test Dr.Phil ::.");
            f.addCommand(new Command("Kembali") {

                
                public void actionPerformed(ActionEvent ae) {
                    startApp();
                }
            });
            f.addCommand(new Command("Masuk", 1) {

                
                public void actionPerformed(ActionEvent ae) {
                    tampilan();
                }
            });
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }	// akhir method getBeranda

    public void getPengaturanTema() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));

            Form f = new Form();
            Button tombol1 = new Button("Java Theme", Image.createImage("/icon.png"));
            tombol1.getStyle().setBorder(Border.createEtchedRaised());
            tombol1.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    setTheme("/javaTheme.res");
                }
            });
            Button tombol2 = new Button("Star Theme", Image.createImage("/icon.png"));
            tombol2.getStyle().setBorder(Border.createEtchedRaised());
            tombol2.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    setTheme("/starTheme.res");
                }
            });

            Button tombol3 = new Button("Lwuit Theme", Image.createImage("/icon.png"));
            tombol3.getStyle().setBorder(Border.createEtchedRaised());
            tombol3.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    setTheme("/LWUITtheme.res");
                }
            });

            Button tombol4 = new Button("Busin Theme", Image.createImage("/icon.png"));
            tombol4.getStyle().setBorder(Border.createEtchedRaised());
            tombol4.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent ae) {
                    setTheme("/businessTheme.res");
                }
            });

            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            f.addComponent(tombol1);
            f.addComponent(tombol2);
            f.addComponent(tombol3);
            f.addComponent(tombol4);
            f.setTitle(".:: Pengaturan Tema ::.");
            f.addCommand(new Command("Kembali") {

                
                public void actionPerformed(ActionEvent ae) {
                    tampilan();
                }
            });
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getAnalisa() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));

            Form f = new Form();
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            Label spasi = new Label();
            Label a = new Label("");
            a.setAlignment(Label.CENTER);

            Button tombol1 = new Button("Score > 60: PENGATUR");
            tombol1.getStyle().setBorder(Border.createEtchedRaised());
            tombol1.getStyle().setBgTransparency(100);
            tombol1.getStyle().setMargin(3, 3, 35, 35);

            tombol1.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    getAnalisaPengatur();
                }
            });

            Button tombol2 = new Button("Score 51 s/d 60: MOTIVATOR ");
            tombol2.getStyle().setBorder(Border.createEtchedRaised());
            tombol2.getStyle().setBgTransparency(100);
            tombol2.getStyle().setMargin(3, 3, 35, 35);

            tombol2.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    getAnalisaMotivator();
                }
            });

            Button tombol3 = new Button("Score 41 s/d 50: PENGHIBUR");
            tombol3.getStyle().setBorder(Border.createEtchedRaised());
            tombol3.getStyle().setBgTransparency(100);
            tombol3.getStyle().setMargin(3, 3, 35, 35);

            tombol3.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    getAnalisaPenghibur();
                }
            });

            Button tombol4 = new Button("Score 31 s/d 40: BIJAK");
            tombol4.getStyle().setBorder(Border.createEtchedRaised());
            tombol4.getStyle().setBgTransparency(100);
            tombol4.getStyle().setMargin(3, 3, 35, 35);

            tombol4.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    getAnalisaBijak();

                }
            });

            Button tombol5 = new Button("Score 21 s/d 30: PERFECT");
            tombol5.getStyle().setBorder(Border.createEtchedRaised());
            tombol5.getStyle().setBgTransparency(100);
            tombol5.getStyle().setMargin(3, 3, 35, 35);

            tombol5.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    getAnalisaPerfect();

                }
            });

            Button tombol6 = new Button("Score < 21: PENCEMAS");
            tombol6.getStyle().setBorder(Border.createEtchedRaised());
            tombol6.getStyle().setBgTransparency(100);
            tombol6.getStyle().setMargin(3, 3, 35, 35);

            tombol6.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    getAnalisaPencemas();

                }
            });

            f.setTitle(".:: Analisa Kepribadian ::.");
            f.addComponent(spasi);
            f.addComponent(a);
            f.addComponent(tombol1);
            f.addComponent(tombol2);
            f.addComponent(tombol3);
            f.addComponent(tombol4);
            f.addComponent(tombol5);
            f.addComponent(tombol6);

            f.addCommand(new Command("Kembali") {

                
                public void actionPerformed(ActionEvent ae) {
                    tampilan();
                }
            });


            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error [1], gambar tidak ditemukan " + ie.toString());
        }
    }

    public void getAnalisaPengatur() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
            TextArea area = new TextArea(analisaPengatur, 10, 10);
            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            f.addComponent(area);
            f.setTitle(".:: TYPE PENGATUR ::.");
            f.addCommand(new Command("Kembali") {
               public void actionPerformed(ActionEvent ae) {
                    getAnalisa();
                }
            });
            
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getAnalisaMotivator() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
            TextArea area = new TextArea(analisaMotivator, 10, 10);
            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            f.addComponent(area);
            f.setTitle(".:: TYPE MOTIVATOR ::.");
            f.addCommand(new Command("Kembali") {
                public void actionPerformed(ActionEvent ae) {
                    getAnalisa();
                }
            });
           
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getAnalisaPenghibur() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
            TextArea area = new TextArea(analisaPenghibur, 10, 10);
            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            f.addComponent(area);
            f.setTitle(".:: TYPE PENGHIBUR ::.");
            f.addCommand(new Command("Kembali") {
                public void actionPerformed(ActionEvent ae) {
                    getAnalisa();
                }
            });
           
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getAnalisaBijak() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
            TextArea area = new TextArea(analisaBijak, 10, 10);
            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            f.addComponent(area);
            f.setTitle(".:: TYPE BIJAK ::.");
            f.addCommand(new Command("Kembali") {
                public void actionPerformed(ActionEvent ae) {
                    getAnalisa();
                }
            });
            
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getAnalisaPerfect() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
            TextArea area = new TextArea(analisaPerfect, 10, 10);
            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            f.addComponent(area);
            f.setTitle(".:: TYPE PERFECT ::.");
            f.addCommand(new Command("Kembali") {
                public void actionPerformed(ActionEvent ae) {
                    getAnalisa();
                }
            });
           
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getAnalisaPencemas() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
            TextArea area = new TextArea(analisaPencemas, 10, 10);
            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
            f.addComponent(area);
            f.setTitle(".:: TYPE PENCEMAS ::.");
            f.addCommand(new Command("Kembali") {
                public void actionPerformed(ActionEvent ae) {
                    getAnalisa();
                }
            });
           
            f.show();
        } catch (java.io.IOException ie) {
            System.err.println("ada yg error" + ie.toString());
        }

    }

    public void getPetunjuk() {
        Display.init(this);
        try {
            if (name == null) {
                name = "/javaTheme.res";
            }

            com.sun.lwuit.util.Resources res = com.sun.lwuit.util.Resources.open(name);
            com.sun.lwuit.plaf.UIManager.getInstance().setThemeProps(res.getTheme(res.getThemeResourceNames()[0]));
            Form f = new Form();
			String petunjuk = "Pilihlah jawaban sesuai pilihan anda di setiap pertanyaan. Setiap pilihan dari pertanyaan memiliki point yang akan dijumlahkan " +
							  "diakhir pertanyaan. Jumlah dari point tersebut yang akan menentukan Tipe Kepribadian anda. Selamat Mencoba :) ";
            TextArea area = new TextArea(petunjuk, 10, 10);
			            area.setEditable(false);
            f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            area.setAlignment(TextArea.CENTER);
			
            f.addComponent(area);
            f.setTitle(".:: Petunjuk Aplikasi ::.");
            f.addCommand(new Command("Kembali") {
                public void actionPerformed(ActionEvent ae) {
                    tampilan();
                }
            });
           
            f.show();
        } catch (Exception ie) {
           ie.printStackTrace();
        }

    }
}

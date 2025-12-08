##File10 nedir?
File10 bir dosya analiz, işleme, benzerlik ve yönetim yazılımıdır.
File10, Nursal Haney ve BT10 şirketi tarafından Balıkesir Üniversitesi Bilgisayar Bölümü öğrencileri ile beraber geliştirilmektedir.
File10 kişisel kullanım için Açık Kaynak Kodları ile beraber ve ücretsiz olarak sağlanmaktadır.
Kurumsal kullanım için, merkezi sunuculu, yüksek performanslı, kurumsal ihtiyaçları adresleyen, çok fonksiyonlu, entegrasyon özellikleri güçlü bir ticari sürüm gelecekte sağlanacaktır.

##File10 ile ne yapabilirsiniz?
* Bilgisayarınızdaki klasör ve dosyalarınızın yapısını, isimlerini, özelliklerini, içeriklerini, mükerrerleri, benzerlikleri detaylı olarak analiz edebilirsiniz.
* Dosyalarınızı arşivleyebilir, yedekleyebilir, dosyalarınızdaki değişiklikleri izleyebilirsiniz.
* Sabit diskleriniz, takılıp çıkarılabilir diskleriniz ve internet sürücülerinizde ne olduğunu detaylı olarak kataloglayabilir, inceleyebilir ve kişisel dosyalarınızı yönetebilirsiniz.
* Sorgular, filtreler oluşturabilir, arama yapabilir, bunların sonuçlarından listeler, raporlar ve görseller oluşturabilirsiniz.
* Dosyalarınızı kataloglayabilir, sınıflandırabilir, gruplayabilir ve indeksleyebilirsiniz.
* Klasör ve dosyalarınız üzerinde isim değişiklikleri, özellik değişiklikleri, format değişiklikleri, dosya işlemleri yapabilirsiniz, klasör yapılarını değiştirebilirsiniz.
* Silme, kopyalama, senkronize etme, sıkıştırma, şifreleme gibi işlemler yapabilirsiniz.

##File10 ile Şirket Çalışanları ve Bilgi İşlem Uzmanları,
* KOBİ’lerde, büyük şirketlerde bilgisayarlarındaki dosyalar için belirtilen işleri yapabilir.
* Şirketlerindeki sunucular ve ağa bağlı bilgisayarlar için belirtilen işleri daha büyük ölçeklerde yapabilir.

##File10 ile
* Dosyalarınız hakkında daha fazla bilgi sahibi olun, elinizde ne var öğrenin. Verileriniz en önemli varlıklarınızdır.
* Aradığınıza kolayca ulaşın, aradığınızı kolayca bulun. Zamanınız önemli, verinin içinde boğulmayın.
* Verilerinizi kolayca, akıllıca yönetin, kolayca dönüştürün. Güçlü araçlar işleri kolaylaştırır.

##File10 bunları nasıl yapar?
* File10 bilgisayarlarınızda bulunan klasörler ve dosyaları tarayarak klasör yapısı, dosya isimleri, büyüklükleri, dosya türleri, özellikleri, erişim hakları, dosya etiketleri, işletim sistemi tarafından yönetilen bir çok özelliği ile ilgili detaylı bir veri havuzu oluşturur.
* File10 bilgisayarınızda tek dosya şeklinde yönetim gerektirmeyen bir Sqlite veritabanı oluşturup verilerinizi bu veritabanına indeksleyerek kaydeder.
* File10 dosyaların içeriklerini de bu veritabanına kaydedebilir, kaydetmeden önce sıkıştırma ve şifreleme işlemleri yapabilir. Bu işlemleri büyük dosyaları parçalara ayırarak ve küçükleri de bir araya getirerek yapar.
* File10 dosyaların özellikleri ve içeriği için istatistikler üretir, hazır sorguları çalıştırmanızı, raporlar üretmenizi sağlar.
* File10 dosya ve klasörler içinde isim, özellik ve içerik olarak mükerrer/duplike olanlarının bulunmasını sağlar.
* File10 benzerlikler ve değişik kısımların bulunması için farklı ve ayrıntılı metodlar sağlar.
* File10 dosyaların, klasörlerin isim, yapı ve içeriklerinin original şekliyle veya dönüştürülerek bilgisayarınızda veya başka bilgisayarlarda açılmasını ve byu şekilde taşınmasını sağlar.
* File10 veritabanındaki verilerin, içeriklerin ve sorgu sonuçlarının CSV, XML, SQL, Excel gibi farklı formatlarda dışarı aktarılmasını sağlar, bu şekilde başka ortamlarda da ayrıntılı işlem ve analizlerin yapılmasına imkan verir.
* File10 bir çok ayrıntılı işlemin komut satırından yapılmasını sağlar.
* File10 Java ve Python (ileride Rust, C/C++, C#, Node.js vs.) için sunduğu erişim kütüphaneleri ile ve doğrudan Sqlite veritabanı erişimi ile programlarınızda da File10’un güçlü özelliklerinin kullanımına imkan sağlar.


## Synopsis

A classic Connect4 game developed in **Java** under **GPL3** license.

There are three different game modes:
* **Connect4:** the classic game in which players playing in alternate turns try to connect 4 tokens of their color either horizontally, vertically or diagonally in a board of 7 columns and 6 rows.
* **Pop Out:** a variation of the classic game in which players playing in alternate turns, are trying to connect 4 tokens of their color either horizontally, vertically or diagonally as well in a board of 4 columns and 6 rows. Nevertheless, when a column is full of tokens, players still can drop tokens on the column and displace the token which lies on the base slot out of the board. Thus, this means that you can make the other player win by mistake or two players can have 4 tokens connected at the same time. In this case, the game finishes when one and only one players connects 4 tokens in-a-row.
* **Gravity:** a variation of the classic game in which players playing in alternate turns, trying to connect 4 tokens of their color either horizontally, vertically or diagonally in a board whose dimensions can vary from 5 to 15 rows or columns respectively. In this case, tokens are attracted to the closest wall in which they are dropped. The resulting position of a token is computed as the sum of all the forces of gravity that the token is 

Players can be either **human** or **computer** and it can be played in both **graphic** or **console** mode.

## History

This game is centuries old, Captain James Cook used to play it with his fellow officers on his long voyages, and so it has also been called *"Captain's Mistress"*. Milton Bradley (now owned by Hasbro) published a version of this game called *"Connect Four"* in 1974.

Other names for this this game are "Four-in-a-Row" and "Plot Four".

## Motivation

The project corresponded initially to the final assignment of *"Programming Systems Laboratory"* course at the **Faculty of Computer Science of Complutense University of Madrid** during the *academic course 2007/2008*.

After a long time, I've decided finally to take it out from the burden of memories, to blow the dust off it, to enhance it and lastly to make it public as part of my open source portfolio that I am putting together.

## Installation

Once you have cloned the repository, it is up to you how to run the application. Compile the code, generate a .jar file or run directly the **Main** class. Alternatively, you could make use of an IDE as Eclipse or Netbeans for editing, compiling and running the code more easily.

By default, a new *connect4* game with both players as *human* with the *graphic* interface is created.
Nonetheless, you can configure your own game options via console by passing the following parameter to the program:  (-i|--interface) console

The following options are available:
* **(-g|--game)** selects the game type:
  * connect4
  * popout
  * gravity

Exceptionally, for *gravity* games, the dimensions of the board can be specified:
* **(-w|width)**
* **(-r|rows)**
These dimensions are **10x10** by default for a gravity game.

## Tests

Just simply invoke the command line runner from the console as follows:
```
java -cp bin:lib/junit-4.4.jar org.junit.runner.JUnitCore tests.AllTests
```


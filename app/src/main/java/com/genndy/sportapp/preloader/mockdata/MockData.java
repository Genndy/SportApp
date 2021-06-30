package com.genndy.sportapp.preloader.mockdata;

import com.genndy.sportapp.content.gallery.models.Photo;
import com.genndy.sportapp.content.players.model.Player;
import com.genndy.sportapp.content.rules.models.Rules;
import com.genndy.sportapp.menu.models.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MockData {
    private List<Game> games = new ArrayList<Game>();
    private List<Player> players = new ArrayList<Player>();
    private List<Rules> rules = new ArrayList<Rules>();
    private List<Photo> photos = new ArrayList<Photo>();

    public MockData(){
        games.add(new Game(UUID.randomUUID().toString(), "Football", "https://pbs.twimg.com/media/Ex81KpQXAAAmjYj.jpg"));
        games.add(new Game(UUID.randomUUID().toString(), "Basketball", "https://media.wgrz.com/assets/WGRZ/images/9d721389-da74-4cb4-a33e-b94e7fadaf19/9d721389-da74-4cb4-a33e-b94e7fadaf19_750x422.jpg"));

        players.add(new Player(UUID.randomUUID().toString(), "John", "https://c.files.bbci.co.uk/8DF9/production/_110654363_kobebryant.jpg", "Basketball"));
        players.add(new Player(UUID.randomUUID().toString(), "Kirill", "http://www.basketclab.ru/wp-content/uploads/2017/01/Kobe-Bryant.jpg", "Basketball"));
        players.add(new Player(UUID.randomUUID().toString(), "Jordan", "https://www.gannett-cdn.com/presto/2019/10/16/PDEM/29d8e20e-c55f-4c08-a783-de374732290d-1016_ISUmbbmediaday_32.JPG", "Basketball"));
        players.add(new Player(UUID.randomUUID().toString(), "CT", "https://cdn2.newsok.biz/cache/large960_blur-2f0757741e4712be315f77bc91f1fc22.jpg", "Basketball"));
        players.add(new Player(UUID.randomUUID().toString(), "SomeRandomGuy", "https://img.bleacherreport.net/img/slides/photos/004/365/033/hi-res-93edb95d05f40043076eacfdcb13a878_crop_exact.jpg?w=2975&h=2048&q=85", "Basketball"));
        players.add(new Player(UUID.randomUUID().toString(), "IDK", "https://cdn.vox-cdn.com/thumbor/nweNZkx2q53SfYn1liB9B31aJMQ=/0x0:5184x3456/1200x800/filters:focal(1963x774:2791x1602)/cdn.vox-cdn.com/uploads/chorus_image/image/67982621/1206470834.0.jpg", "Basketball"));
        players.add(new Player(UUID.randomUUID().toString(), "Kris", "https://www.gannett-cdn.com/-mm-/b85f4c1c20c89f108065085bc29a1c87399b1373/c=0-114-1571-2209/local/-/media/2020/11/15/Rockford/ghows-IR-200909836-bb83f972.jpg", "Basketball"));
        players.add(new Player(UUID.randomUUID().toString(), "Sarah", "https://a.espncdn.com/photo/2021/0105/r798170_1296x729_16-9.jpg", "Basketball"));
        players.add(new Player(UUID.randomUUID().toString(), "Faith", "https://bloximages.chicago2.vip.townnews.com/406mtsports.com/content/tncms/assets/v3/editorial/a/1a/a1ac34ef-054c-53dd-9809-2c332c222b9b/5f24c12e9ff76.image.jpg?crop=1567%2C1175%2C98%2C0&resize=1567%2C1175&order=crop%2Cresize", "Basketball"));
        players.add(new Player(UUID.randomUUID().toString(), "Alis", "https://snworksceo.imgix.net/tsn/3e3faf6c-2912-454f-ab49-b2357afffb12.sized-1000x1000.JPG?w=1000", "Basketball"));

        players.add(new Player(UUID.randomUUID().toString(), "David", "https://images2.minutemediacdn.com/image/upload/c_fill,w_912,h_516,f_auto,q_auto,g_auto/shape/cover/sport/france-v-germany-uefa-nations-league-a-5bca0ac66f0e5b6500000001.jpg", "Football"));
        players.add(new Player(UUID.randomUUID().toString(), "Lee", "https://i.insider.com/5f6096fc57b7da001ee11943?width=700", "Football"));
        players.add(new Player(UUID.randomUUID().toString(), "Messi", "https://weproject.media/upload/medialibrary/a67/a676f175b5452a5a626c7ed8d70acce4.jpg", "Football"));
        players.add(new Player(UUID.randomUUID().toString(), "Lionel", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4DWk19Ph07mXV02MNotuOXznfVnZu-VXcog&usqp=CAU", "Football"));
        players.add(new Player(UUID.randomUUID().toString(), "CJ", "https://amayei.nyc3.digitaloceanspaces.com/2018/09/salaah.jpg", "Football"));
        players.add(new Player(UUID.randomUUID().toString(), "John", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVhwtAJj3GhTdaf5-yK8VfcoGL9HvwV3mPcQ&usqp=CAU", "Football"));
        players.add(new Player(UUID.randomUUID().toString(), "Jack", "https://i.insider.com/5de525befd9db2198441dde2?width=750&format=jpeg&auto=webp", "Football"));
        players.add(new Player(UUID.randomUUID().toString(), "John", "https://miro.medium.com/max/623/1*n_e1KZn02CGkM_bo5V6ILQ.jpeg", "Football"));
        players.add(new Player(UUID.randomUUID().toString(), "Mikel", "https://www.independent.ie/entertainment/273b0/37979343.ece/AUTOCROP/w620/ipanews_aa8a689e-a4a7-46f8-9b24-40d22f0009e3_1", "Football"));
        players.add(new Player(UUID.randomUUID().toString(), "Bob", "https://e0.365dm.com/19/03/768x432/skysports-declan-rice-england_4618843.jpg?20190325144415", "Football"));
        players.add(new Player(UUID.randomUUID().toString(), "Johnson", "https://worldinsport.com/wp-content/uploads/2020/10/Clarence-Seedorf.jpg", "Football"));
        players.add(new Player(UUID.randomUUID().toString(), "Johny", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpgsSMDwx4Cd6Nt_ISoHvBgr_h_eUBrNailw&usqp=CAU", "Football"));

        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1577471488278-16eec37ffcc2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80", "Basketball"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1580692475446-c2fabbbbf835?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2062&q=80", "Basketball"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1558648243-33c2ca3bf161?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=701&q=80", "Basketball"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1531399597742-fbf70c342ece?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=634&q=80", "Basketball"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1556168505-d00e911d52eb?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=968&q=80", "Basketball"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1562519819-016930ada31b?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80", "Basketball"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1561781019-88612f6d492c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=634&q=80", "Basketball"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1594623274890-6b45ce7cf44a?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80", "Basketball"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1593696326140-3ad13224e54b?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=751&q=80", "Basketball"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1532040683343-edbde6dd500d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=755&q=80", "Basketball"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1526086754506-a57f69b4700a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=700&q=80", "Basketball"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1553174968-b6b7bb5f1e86?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=634&q=80", "Basketball"));

        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1508098682722-e99c43a406b2?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80", "Football"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1553778263-73a83bab9b0c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=751&q=80", "Football"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1606925797300-0b35e9d1794e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=801&q=80", "Football"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1431324155629-1a6deb1dec8d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80", "Football"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1517747614396-d21a78b850e8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=564&q=80", "Football"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1517466787929-bc90951d0974?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=633&q=80", "Football"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1434648957308-5e6a859697e8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=967&q=80", "Football"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1600250395178-40fe752e5189?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=889&q=80", "Football"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1600679472829-3044539ce8ed?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=750&q=80", "Football"));
        photos.add(new Photo(UUID.randomUUID().toString(), "https://images.unsplash.com/photo-1473976345543-9ffc928e648d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1085&q=80", "Football"));

        rules.add(new Rules(UUID.randomUUID().toString(), "Football",
"    Футбол является одним из самых старейших, популярных и узнаваемых видов спорта в мире. Официальной датой зарождения соккера считается 8 декабря 1863 г. Именно тогда на лондонской встрече были созданные первые 13 правил. Всего на сегодняшний день существует 17 основных правил футбола. Самое главное условие футбольной игры заключается в том, что игрокам разрешается использовать любую часть тела для забивания мяча в ворота, кроме рук. Руками играть может только вратарь, и то в своей штрафной площади.\n" +
        "\n" +
        "    Итак, разберём главные моменты игры. Ниже представлены главные правила большого футбола кратко для начинающих, расписанные в доступном и понятном виде. Этой информацией могут пользоваться, как учителя физической культуры, так и тренеры, для объяснения игры школьникам и детям разного возраста.\n" +
        "Основные правила футбольной игры\n" +
        "Основная цель футбольного матча – забить больше голов, чем соперник за 90 минут игрового времени. Поединок делится на две равные половины (каждая по 45 минут). Между таймами есть перерыв на отдых, длительностью не более 15 минут.\n" +
        "\n" +
        "    В футбольном матче одновременно принимают участие 22 игрока, по 11 человек с каждой стороны (1 – голкипер, 10 – полевых). Смотрите какие бывают позиции игроков в футболе. Игра проводиться на травянистом покрытии. Поле должно иметь прямоугольную форму примерного размера 100 на 60 метров " +
        "Формы команд должны быть разного цвета, чтобы не путаться. Полное обмундирование игрока включает в себя: футболку, шорты, гетры, бутсы (или другая шипованная обувь). У голкипера должны быть перчатки.\n" +
        "\n" +
        "    Взятие ворот считается законным, когда мяч полностью пересёк линию ворот. Забить гол, как уже упоминалось выше, можно любой частью тела, кроме рук." +
        "Если после 90 минут игры счёт будет равным, то по правилам, в некоторых турнирах (зачастую это кубковые соревнования или финалы), судья добавляет два дополнительных тайма каждый по 15 минут. Если и в экстратаймах победитель не выявлен, пробиваются пенальти (11-и метровые удары)." +
        "Процедура пенальти в футболе такова: от каждой стороны выбирается по 5 бьющих. Каждый игрок выполняет по одному удару. В том случае, когда счёт после пяти ударов с каждой стороны равный, остальные футболисты, до этого не выполнявшие удар, также участвуют в серии пенальти. Процедура длиться до тех пор, пока не будет выявлен победитель после одинакового количества ударов." ));

        rules.add(new Rules(UUID.randomUUID().toString(), "Basketball",
                "1.  Мяч может быть брошен в любом направлении одной или двумя руками.\n" +
                        "2.  Мяч может быть отбит в любом направлении одной или двумя руками.\n" +
                        "3.  Игрок не может бежать с мячом. Игрок должен бросить мяч с того места, где он его поймал, с допущением броска, когда игрок получает мяч на хорошей скорости и пытается остановиться.\n" +
                        "4.  Мяч нужно держать кистями рук; нельзя использовать руки или тело для удержания мяча.\n" +
                        "5.  Нельзя никоим образом толкать, бить, держать, опрокидывать и подрезать оппонента. Первое нарушение этого правила любым игроком должно считаться фолом; после второго нарушения игрок удаляется с площадки до следующего забитого мяча или, если была очевидная попытка травмирования оппонента, до конца игры. Замена запрещается.\n" +
                        "6.  Удар по мячу кулаком является фолом, так как нарушает третье и четвертое правила, и наказывается тем же способом, который описан в пункте 5.\n" +
                        "7.  Если одна из команд совершает три последовательных фола, не прерываемых при этом фолами противника, то это считается забитым противником голом.\n" +
                        "8.  Забитым мячом считается мяч, когда он брошен или отбит с земли в корзину и не выпал, если защитники не касались мяча и не мешали попаданию. Если мяч покоится на краях, и защитник двигает корзину, это считается забитым мячом.\n" +
                        "9.  Когда мяч выходит за пределы площадки, он должен быть вброшен или отбит в игровое поле первым коснувшимся игроком. В случае спора арбитр должен вбросить мяч прямо в площадку. На вброс мяча игроку дается пять секунд. Если он держит мяч дольше, мяч отдается оппоненту. Если одна из сторон продолжает задерживать игру, то арбитр засчитывает ей фол.\n" +
                        "10.  Арбитр должен следить за игроками, отмечать фолы и уведомлять судей, когда случаются три последовательных фола. Он вправе удалять игроков в соответствии с правилом 5.\n" +
                        "11.  Судья должен следить за мячом и решать, когда мяч находится в игре, в стадии вбрасывания, чья сторона им владеет, и должен следить за временем. Он должен определять, когда команда забивает мяч и вести счёт, исполняя также любые другие процессуальные обязанности.\n" +
                        "12.  Игра должна длиться два тайма по пятнадцать минут с пятиминутным перерывом между ними.\n" +
                        "13.  Победившей считается команда, забившая большее количество очков." ));
    }

    public List<Game> getGames() {
        return games;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Rules> getRules() {
        return rules;
    }

    public List<Photo> getPhotos() {
        return photos;
    }
}

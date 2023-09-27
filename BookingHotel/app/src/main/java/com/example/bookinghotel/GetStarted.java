package com.example.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bookinghotel.database.DatabaseHandler;
import com.example.bookinghotel.database._0_blogs;
import com.example.bookinghotel.database._0_comments;
import com.example.bookinghotel.database._0_countries;
import com.example.bookinghotel.database._0_hotel_details;
import com.example.bookinghotel.database._0_hotels;
import com.example.bookinghotel.database._0_likes;
import com.example.bookinghotel.database._0_orders;
import com.example.bookinghotel.database._0_users;

import java.sql.Date;

public class GetStarted extends AppCompatActivity {
    Button _76, _77;
    DatabaseHandler db = new DatabaseHandler(this);

    public void findViewById() {
        _76 = findViewById(R.id._76);
        _77 = findViewById(R.id._77);
    }

    public void setOnClickListener() {
        _76.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GetStarted.this, LogIn.class);
                startActivity(i);
            }
        });
        _77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GetStarted.this, SignUp.class);
                startActivity(i);
            }
        });
    }

    public void others() {
        db.addUsers(new _0_users("1", "", "", "", ""
                , "", "", "", "Tuan", "lengoctuan2406@gmail.com", "abc123", "24/06/2001", "Nam", "0984121887", R.drawable.tuan, "", "", ""));
        db.addUsers(new _0_users("2", "", "", "", ""
                , "", "", "", "Thanh Phat", "thanhphatn@gmail.com", "phat1806", "18/06/2003", "Nam", "0975232978", R.drawable.thanhphat, "", "", ""));
        db.addUsers(new _0_users("3", "", "", "", ""
                , "", "", "", "Duc Huy", "duchuyl66@gmail.com", "2358aa", "06/06/2000", "Nam", "0966344069", R.drawable.ducduy, "", "", ""));
        db.addUsers(new _0_users("4", "", "", "", ""
                , "", "", "", "Minh Son", "minhsonn55@gmail.com", "son5560", "05/05/2000", "Nam", "0957455160", R.drawable.minhson, "", "", ""));
        db.addUsers(new _0_users("5", "", "", "", ""
                , "", "", "", "Thoai", "thoai2001@gmail.com", "thoidethuong", "26/03/1965", "Nu", "0948566251", R.drawable.ngocthoai, "", "", ""));
        db.addUsers(new _0_users("6", "", "", "", ""
                , "", "", "", "Thanh", "thanh2001@gmail.com", "khungthanh0310", "24/05/1998", "Nu", "0939677342", R.drawable.thanh, "", "", ""));
        db.addUsers(new _0_users("7", "", "", "", ""
                , "", "", "", "Minh Toan", "toanle@gmail.com", "minhtoan", "21/11/1999", "Nam", "0930788433", R.drawable.minhtoan, "", "", ""));
        db.addUsers(new _0_users("8", "", "", "", ""
                , "", "", "", "Minh Thu", "thule2001@gmail.com", "thu2001", "23/08/2001", "Nu", "0921899524", R.drawable.minhthu, "", "", ""));
        db.addUsers(new _0_users("9", "", "", "", ""
                , "", "", "", "Nhat Khuo", "khuetran@gmail.com", "khuetran2001", "05/05/2001", "Nu", "0913010615", R.drawable.khue, "", "", ""));
        db.addUsers(new _0_users("10", "", "", "", ""
                , "", "", "", "Tran My", "mytran@gmail.com", "mytranq12", "12/04/1997", "Nu", "0904121706", R.drawable.tranmu, "", "", ""));
        db.addUsers(new _0_users("11", "", "", "", ""
                , "", "", "", "Cardi B", "nsnd@gmail.com", "cadibi", "15/11/1993", "Nu", "0995232797", R.drawable.cardib, "", "", ""));
        db.addUsers(new _0_users("12", "", "", "", ""
                , "", "", "", "Trang Nemo", "trangnemo@gmail.com", "canemo", "23/05/1990", "Nu", "0986343888", R.drawable.trangnemo, "", "", ""));
        db.addUsers(new _0_users("13", "", "", "", ""
                , "", "", "", "Linh Ka", "linh2002@gmail.com", "belinh2k2", "21/12/2002", "Nu", "0918998778", R.drawable.linhka, "", "", ""));
        db.addUsers(new _0_users("14", "", "", "", ""
                , "", "", "", "Chi Pu", "singer@gmail.com", "casichipu", "25/11/1995", "Nu", "0912546255", R.drawable.chipu, "", "", ""));
        db.addUsers(new _0_users("15", "", "", "", ""
                , "", "", "", "Hung Dam", "hungdam@gmail.com", "mrDam1", "08/12/1970", "Nam", "0912634980", R.drawable.hungdam, "", "", ""));
        db.addUsers(new _0_users("16", "", "", "", ""
                , "", "", "", "Thao Vy", "vynguyen@gmail.com", "vythaonguyen", "10/06/2001", "Nu", "0918997676", R.drawable.thaovy, "", "", ""));
        db.addUsers(new _0_users("17", "", "", "", ""
                , "", "", "", "Vinh Hào", "haocao2000@gmail.com", "caovinhhao", "10/06/2000", "Nam", "0853693000", R.drawable.vinhhao, "", "", ""));
        db.addUsers(new _0_users("18", "", "", "", ""
                , "", "", "", "Minh Khoa", "khoanguyen@gmail.com", "khoacho", "10/07/2001", "Nam", "0918505020", R.drawable.minhkhoa, "", "", ""));
        db.addUsers(new _0_users("19", "", "", "", ""
                , "", "", "", "Anh Thu", "thuanh@gmail.com", "thu2411", "24/11/2000", "Nu", "0856772345", R.drawable.anhthu, "", "", ""));
        db.addUsers(new _0_users("20", "", "", "", ""
                , "", "", "", "Chi_Tam", "chitam@gmail.com", "chitam123", "20/03/1998", "Nu", "0986767898", R.drawable.chitam, "", "", ""));

        db.addHotel(new _0_hotels("", "1", "2", "", ""
                , "", "", "", "VinPearl Landmark",
                "Vinpearl Landmark 81, Autograph Collection features a fitness center, bar and city views. This hotel also has a 24-hour front desk, a restaurant and an outdoor pool. The property offers room service and concierge service.",
                R.drawable.vinpearllm_canhquan, "Vinhomes Central Park Binh Thanh District, Binh Thanh District, Ho Chi Minh City, Vietnam ",
                5));
        db.addHotel(new _0_hotels("", "2", "3", "", ""
                , "", "", "", "Minh Nhan Hotel",
                "Minh Nhan Hotel restaurant is available on site to serve your needs conveniently.", R.drawable.minhnhanhotel_tongquan_1,
                "24A Nguyen Hien, Ward 2, Vung Tau, Vietnam",
                4));
        db.addHotel(new _0_hotels("", "3", "3", "", ""
                , "", "", "", "The Imperial Hotel & Resort",
                "Imperial Hotel & Resort is rated 5 stars, this high-quality property allows guests to enjoy massages, outdoor swimming pools and on-site sauna.",
                R.drawable.imperialhotel_canhquan, "159 Thuy Van Street, Thang Tam Ward, Thang Tam, Vung Tau, Vietnam",
                5));
        db.addHotel(new _0_hotels("", "4", "6", "", ""
                , "", "", "", "Hanah Hotel",
                "This 3-star hotel offers air-conditioned rooms with free Wi-Fi, each with a private bathroom. It offers city views, a terrace and a 24-hour front desk.",
                R.drawable.hanahhotel_canhquan, "A6-73 Rang Dong beach street, Phu Thuy ward. Phan Thiet City, Phan Thiet, Vietnam",
                4));
        db.addHotel(new _0_hotels("", "5", "6", "", ""
                , "", "", "", "LuxSea Villa",
                "Located in Phan Thiet in Binh Thuan and Dia Rock Beach within a 19-minute walk, LuxSea Villa offers accommodation with free Wi-Fi, a playground, a garden and free private parking.",
                R.drawable.luxseavilla_canhquan, "S48 - Sea Link Km9, Nguyen Thong Phu Hai, Phan Thiet, Vietnam",
                3));
        db.addHotel(new _0_hotels("", "6", "5", "", ""
                , "", "", "", "La Sera Hotel",
                "La Sera Hotel in Nha Trang offers panoramic views that guests can enjoy at the sky pool bar. Guests can enjoy a meal at the on-site restaurant.",
                R.drawable.laserahotel_canhquan_1, "98B/7 Tran Phu, Nha Trang, Vietnam",
                4));
        db.addHotel(new _0_hotels("", "7", "5", "", ""
                , "", "", "", "Sea View Luxury - Apartments",
                "Featuring a swimming pool, fitness center, garden and sea views, Sea View Luxury - Apartments is located in Nha Trang and offers accommodation with free Wi-Fi.",
                R.drawable.seaviewluxuryapartments_2phong, "32 Tran Phu, Nha Trang, Vietnam",
                4));
        db.addHotel(new _0_hotels("", "8", "7", "", ""
                , "", "", "", "Santa Garden Resort", "Santa Garden Resort features an outdoor pool, fitness center, garden and restaurant in Phu Quoc town. This 4-star resort features a bar",
                R.drawable.santagardenresort_2phong_1, "Cua Lap - Suoi May Santa Garden Resort, Duong Dong, Phu Quoc, Vietnam",
                5));
        db.addHotel(new _0_hotels("", "9", "4", "", ""
                , "", "", "", "Bazan Hotel Dalat", "Bazan Hotel Dalat offers accommodation with a garden, free private parking and a shared lounge",
                R.drawable.bazanhoteldalat_2phong_2giuong_1, "36 To Hien Thanh , Da Lat, Vietnam",
                5));
        db.addHotel(new _0_hotels("", "10", "1", "", ""
                , "", "", "", "Hotel Del Luna", "Hotel Del Luna offers 4-star accommodation with an indoor pool, sauna and hot tub.",
                R.drawable.hoteldelluna_1giuong_1, "138 Ho Nghinh, Danang, Vietnam",
                5));
        db.addHotel(new _0_hotels("", "11", "2", "", ""
                , "", "", "", "Adora Art Hotel", "ADORA ART HOTEL is the best choice for couples, family and groups of friends to have a great vacation together. Located in the heart of Ho Chi Minh City, visitors can conveniently visit the city's famous attractions.",
                R.drawable.adoraarthotel_canhquan, "189-191 Ly Tu Trong Street, Ben Thanh Ward, District 1, Ho Chi Minh City, Vietnam",
                5));
        db.addHotel(new _0_hotels("", "11", "2", "", ""
                , "", "", "", "Homet Saigon - RiverGate", "Homet Saigon - RiverGate offers accommodation with free WiFi, air conditioning, an outdoor pool and a bar. Private parking is available on site.", R.drawable.hometsaigon_1giuongdoi_canho_1, "151 Ben Van Don, District 4, Ho Chi Minh City, Vietnam",
                5));

        db.addLikes(new _0_likes("1", "1", "", "", "1"
                , "", "", ""));
        db.addLikes(new _0_likes("4", "1", "", "", "2"
                , "", "", ""));
        db.addLikes(new _0_likes("2", "1", "", "", "3"
                , "", "", ""));
        db.addLikes(new _0_likes("3", "2", "", "", "4"
                , "", "", ""));
        db.addLikes(new _0_likes("1", "2", "", "", "5"
                , "", "", ""));
        db.addLikes(new _0_likes("4", "2", "", "", "5"
                , "", "", ""));

        db.addHotelDetail(new _0_hotel_details("", "1", "", "1", ""
                , "", "", "", "Single room", "215",
                "Hotel have bancony, view SaiGon river and have breakfast buffet", 50, 1,
                R.drawable.vinpearllm_canhquan_2,
                R.drawable.vinpearllm_2giuongdon_1,
                R.drawable.vinpearllm_2giuongdon_2));
        db.addHotelDetail(new _0_hotel_details("", "1", "", "2", ""
                , "", "", "", "Double room", "215",
                "Luxury room, have pool infinity view and breakfast buffet", 100, 1,
                R.drawable.vinpearllm_1giuongdoilux_1,
                R.drawable.vinpearllm_1giuongdoilux_2,
                R.drawable.vinpearllm_1giuongdoilux_3));
        db.addHotelDetail(new _0_hotel_details("", "2", "", "3", ""
                , "", "", "", "Single room", "215",
                "Mô tả chi tiết của hotel", 20, 0,
                R.drawable.vinpearllm_canhquan_2,
                R.drawable.vinpearllm_2giuongdon_1,
                R.drawable.vinpearllm_2giuongdon_2));
        db.addHotelDetail(new _0_hotel_details("", "2", "", "4", ""
                , "", "", "", "Double room", "215",
                "Private room", 50, 1,
                R.drawable.minhnhanhotel_1giuongdoi_1,
                R.drawable.minhnhanhotel_1giuongdoi_2,
                R.drawable.minhnhanhotel_1giuongdoi_3));
        db.addHotelDetail(new _0_hotel_details("", "2", "", "5", ""
                , "", "", "", "Double room", "215",
                "King double room and have special service include spa, gyms, swimming", 50, 1,
                R.drawable.minhnhanhotel_2giuongdoi_1,
                R.drawable.minhnhanhotel_2giuongdoi_2,
                R.drawable.minhnhanhotel_2giuongdoi_3));
        db.addHotelDetail(new _0_hotel_details("", "2", "", "6", ""
                , "", "", "", "Tripper room", "215",
                "Room for 3 people and have special service ", 20, 0,
                R.drawable.bazanhoteldalat_mountainview_2phong_1,
                R.drawable.bazanhoteldalat_mountainview_2phong_2,
                R.drawable.bazanhoteldalat_mountainview_2phong_3));
        db.addHotelDetail(new _0_hotel_details("", "2", "", "7", ""
                , "", "", "", "Double room", "215",
                "Room for 2 people have bancony and pool", 50, 1,
                R.drawable.bazanhoteldalat_2phong_2giuong_1,
                R.drawable.bazanhoteldalat_2phong_2giuong_2,
                R.drawable.bazanhoteldalat_2phong_2giuong_3));

        db.addComments(new _0_comments("3", "1", "", "", ""
                , "1", "", "", "Good"));
        db.addComments(new _0_comments("4", "1", "", "", ""
                , "2", "", "", "Not bad"));
        db.addComments(new _0_comments("5", "1", "", "", ""
                , "3", "", "", "Very good"));
        db.addComments(new _0_comments("6", "1", "", "", ""
                , "4", "", "", "Service of hotel is good. Buffet is delicious"));
        db.addComments(new _0_comments("7", "1", "", "", ""
                , "5", "", "", "Very very good"));
        db.addComments(new _0_comments("1", "2", "", "", ""
                , "6", "", "", "Good"));
        db.addComments(new _0_comments("6", "2", "", "", ""
                , "7", "", "", "Not bad"));
        db.addComments(new _0_comments("10", "2", "", "", ""
                , "8", "", "", "Very good"));
        db.addComments(new _0_comments("11", "2", "", "", ""
                , "9", "", "", "Service of hotel is good. Buffet is delicious"));
        db.addComments(new _0_comments("12", "2", "", "", ""
                , "10", "", "", "Very very good"));

        db.addOrders(new _0_orders("1", "", "", "1", ""
                , "", "1", "", "01/01/2022", "02/01/2022", 0, R.drawable.qr_momo));
        db.addOrders(new _0_orders("1", "", "", "2", ""
                , "6", "2", "", "01/02/2022", "01/02/2022", 1, R.drawable.qr_momo));
        db.addOrders(new _0_orders("1", "", "", "2", ""
                , "6", "2", "", "01/02/2022", "01/02/2022", 2, R.drawable.qr_momo));

        db.addBlogs(new _0_blogs("", "", "3", "", ""
                , "", "", "1", "ViVu Vung Tau", "Coming to Vung Tau, you will have a peaceful and pleasant feeling with spacious and airy roads. Vung Tau is full of magic, a Vung Tau city is not only peaceful and idyllic but also countless famous landscapes." +
                "\nBai Sau\nBai Sau Vung Tau Beach is famous for its beautiful coastline and few big waves, with a lot of hotels and dining areas. Therefore, most tourists when traveling to Vung Tau like to stay in Bai Sau.\n" +
                "Bai Truoc \nThe center of Vung Tau city is located in Front Beach. Front Beach will be the ideal place for you to watch the sunset or go for a walk.\n" +
                "Long Hai \nLong Hai has a beautiful beach with clear blue water, stretching yellow sand and resorts near the sea. In particular, Long Hai beach has a lot of fresh seafood at quite cheap prices. Binh Chau hot mineral spring is located on Long Hai tourist route, which is also an interesting stop for visitors.\n" +
                "Ho Coc – Ho Tram\nThe sea here is clear blue water in the bottom of the sand all year round, the white sand beach area is widespread, the slope is gentle and especially beautiful thanks to the rocks located in the beach creating waves of white foam.\n" +
                "Statue of Christ \n" +
                "Statue of Christ or the Statue of God standing on the top of Little Mountain of Vung Tau city, built in 1974. This statue is 32 m high, inside there is a staircase of 133 steps up to 2 hands of the statue.",
                R.drawable.dulichvungtau_vungtau));
        db.addBlogs(new _0_blogs("", "", "1", "", ""
                , "", "", "2", "MOT in Hoi An",
                "This is a very famous drink shop in Hoi An. Tourists usually visit at least once when coming to Hoi An...This is a very famous drink shop in Hoi An. Tourists usually visit at least once when coming to Hoi An…",
                R.drawable.motinhoian));
        db.addBlogs(new _0_blogs("", "", "4", "", ""
                , "", "", "3", "Da Lat Ngan Hoa", "Dalat today no longer retains the same wild look as before. Only about 300km from Saigon, Dalat city is a great resort, helping visitors escape the hot heat of the Southern Plains.\n" +
                "Dalat Market\n" +
                "The destination is not to be missed when traveling to Dalat. There are beautiful and unique second-hand warm clothes along with specialties such as mulberry juice, artichoke tea, dried cruciferous, jams and beans ...\n" +
                "Dalat railway station \n" +
                "Located at 1 Quang Trung, Da Lat (Dalat station). This is a familiar photo location for visitors.\n" +
                "Ghost Forest Inn\n" +
                "Still retaining the unspoiled beauty of the mountain forest, the owner of Ma Forest Inn has created a fanciful scene from aquariums, ornamental trees or wooden houses that fascinate visitors when arriving.\n" +
                "Van Thanh Flower Village\n" +
                "Not only green by large flower fields, petals of all kinds, all colors from simple white, gentle pastel pink to haughty yellow or splendid velvet red will always be enough to immerse you in the world of diverse and brilliant flowers to forget the way back.\n" +
                "Thatched grass hill Lac Duong \n" +
                "With an area of more than 10 hectares of white thatched grass, it has become an ideal tourist and photography destination for many tourists, especially young people and enthusiasts, who love natural landscapes, mountains and forests.\n",
                R.drawable.dalatnganhoa_canhquan));
        db.addBlogs(new _0_blogs("", "", "5", "", ""
                , "", "", "4", "Bien Nha Trang", "Nha Trang has long been famous for many interesting attractions such as islands with beautiful, pristine beaches, ancient indigo towers and typical cuisine of the sea.\n" +
                "Vinpearl Land\n" +
                "Located on Hon Tre Island with clear blue beaches all year round, Vinpearl Land is known as the paradise of the tropics. In addition to luxury hotels, beautiful gardens, ideal freshwater pools, this place also attracts visitors with thrilling game zones and epic 4D cinemas. \n" +
                "Hon Mun Island\n" +
                "Hon Mun has clear waters and a splendid coral ecosystem, which has been rated by the World Wildlife Fund (WWF) as the most marine biodiversity area in Vietnam.\n" +
                "Ninh Van Bay\n" +
                "Ning Yun is wild and pure. This place is especially suitable for those who want to find a sense of relaxation in the calm sea space. In addition, you can also watch coral, scuba dive or try surfing, windsurfing, kayaking.\n" +
                "Dam Market in Nha Trang\n" +
                "This is a beautiful architectural work, located in the center of Nha Trang tourist city. Dam Market sells a lot of souvenirs and local products. There is also a rich concentration of seafood, especially dried seafood.\n",
                R.drawable.biennhatrang));
        db.addBlogs(new _0_blogs("", "", "6", "", ""
                , "", "", "5", "Du Lich Phan Thiet", "Phan Thiet is a city in Binh Thuan Province. Phan Thiet has long been a popular sea tourist destination in Vietnam with its sprawling white sands, blue sea and soaring coconut trees.\n" +
                "Rang Beach\n" +
                "Rang Beach is about 15 km north of the city center, located under dense coconut groves that look like a very beautiful coconut forest. In the summer, Rang Beach is crowded with visitors to the beach and enjoy the sweet grilled blue dragonfly fish. \n" +
                "Bay Sand Dunes in Mui Ne\n" +
                "In addition to the beautiful shape, the color of the sand is also an attraction for many visitors (there are 18 different colors). Up the sand dunes, you can rent a board to play sand skating, only about 5,000VND/sheet. After playing, you can enjoy three-shot coconut, Phan Thiet filter cake ...\n" +
                "Mui Ne fishing village\n" +
                "Walking along the beach covered with sea shells during the catch, especially the dock area and the south of town, you will see how the fishermen classify their catches.\n" +
                "Ganh Son\n" +
                "The red of the rocks, the blue of the sea seem to blend together to create a harmonious shade that is both near, far away, spoiled and real... Ganh Son is indeed a gift of creation that is not known to many people.\n",
                R.drawable.dulichphanthiet));
        db.addBlogs(new _0_blogs("", "", "1", "", ""
                , "", "", "6", "Da Nang", "Da Nang has mountains, plains and seas. Da Nang also has many enchanting landscapes such as Hai Van Pass, primeval forest in Son Tra peninsula and Ngu Hanh Son.\n" +
                "Han River Bridge\n" +
                "The beautiful bridge shimmers and stands out in the middle of the city every time night falls. The special feature is that every night, the Han River Bridge rotates 90 degrees around the middle axis of the bridge for large ships to pass through.\n" +
                "Dragon Bridge \n" +
                "The new bridge was opened in 2013, connecting directly from Da Nang airport to My Khe and Non Nuoc beaches.\n" +
                "Son Tra Peninsula\n" +
                "Son Tra is considered a gem, with a long, winding coastline, and diverse flora and fauna. It has a long coastline, clear all year round, and Hai Van Pass surrounds Da Nang city and Da Nang Bay.\n" +
                "Non Nuoc Beach \n" +
                "Khu travels with airy hills under the Marble Mountains. The sea water is not polluted, clean, attracting domestic and foreign tourists to Da Nang tourism.\n" +
                "Hai Van Pass\n" +
                "It is where the Annamite Range juts out into the sea. Creeping and dangerous, Hai Van Pass is the boundary between the South and the North.\n",
                R.drawable.danang));

        db.addCountries(new _0_countries("", "", "1", "", ""
                , "", "", "", "Da Nang"));
        db.addCountries(new _0_countries("", "", "2", "", ""
                , "", "", "", "Ho Chi Minh"));
        db.addCountries(new _0_countries("", "", "3", "", ""
                , "", "", "", "Vung Tau"));
        db.addCountries(new _0_countries("", "", "4", "", ""
                , "", "", "", "Da Lat"));
        db.addCountries(new _0_countries("", "", "5", "", ""
                , "", "", "", "Nha Trang"));
        db.addCountries(new _0_countries("", "", "6", "", ""
                , "", "", "", "Phan Thiet"));
        db.addCountries(new _0_countries("", "", "7", "", ""
                , "", "", "", "Phu Quoc"));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
        findViewById();
        //others();
        setOnClickListener();
    }
}
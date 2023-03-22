package com.obilet.scase.resources;

public class Constants {
    public static final String globalUrl = "https://www.obilet.com/";

    public static class MemberConst{
        public static final String setUpDescription = "The reason for using chromeDriver here is to get faster results. It can also support different browsers.";
        public static final String tearDownDescription = "The reason why the driver is quit after each test is because of the possibility of being used in the cloud.";
        public static final String loadCorrectlyTitle = "Ucuz Otobüs Bileti Fiyatları, Otobüs Bileti Al - obilet.com";
        public static final String loadCorrectlyDesc="Anasayfayı açılır ve sayfanın doğru şekilde açıldığı kontrol edilir.";
        public static final String checkLoginDescription = "Üye giriş butonuna tıklanır. Üyelik Pop-Up'ının açıldığı görülür. Üye ol butonuna tıklanır";
        public static final String checkLoginHeader = "Üye Girişi";
        public static final String checkRegisterDescription = "Mail ve Password alanı girilerek üye ol butonuna tıklanır.";
        public static final String checkRegisterHeader = "Üye Ol";
        public static final String verifyNewUserDesc = "Yeni kullanıcının başarılı şekilde oluşturulduğu kontrol edilir";
    }

    public static class FlightConst{
        public static final String searchFlightLoadedCorrectlyDesc = "Obilet ana sayfasına girilerek Uçak tabine tıklanır ve Uçak bileti arama sayfasının açıldığı görülür.";
        public static final String searchFlightLoadCorrectlyTitle = "Uçak Bileti Ara, Ucuz Uçak Bileti Al - obilet.com";
        public static final String selectDepartureCityAndDateDesc = "Bir gidiş ili ve gidiş tarihi , bir dönüş ili ve dönüş tarihi seçilir. ";
        public static final String DepartureCity = "İstanbul";
        public static final String DestinationCity = "İzmir";
        public static final String searchAndListFlightDesc = "Seçimler yapıldıktan sonra uçuş ara butonuna tıklanır ve uçuşların listelendiği görülür.";
        public static final String selectDepartureFlight = "Uçuşlardan herhangi bir gidiş uçuşu seçilir.Not: Bazı uçuşlardan tek sınıf bazıları ise  aşağıdakigibi çoklu sınıftır.Çoklu sınıf olup olmadığı var kontrol edilir var ise  Eco uçuş seçilir";
        public static final String ecoFlyString = "Ecofly (EF)";
        public static final String selectReturnFlight = "Uçuşlardan herhangi bir dönüş uçuşu seçilir";
        public static final String paymentDescription = "Ödeme sayfanın başarılı şekilde açıldığını ödeme sayfasındaki gidiş ve dönüş uçusunun seçilen gidiş ve dönüş uçuşu olduğu teyit edilir.";
        public static final String journeyTitleHeader = "UÇUŞ BİLGİLERİ";
    }
}

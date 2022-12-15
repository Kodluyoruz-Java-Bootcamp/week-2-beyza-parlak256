import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import emlakcepte.model.Message;
import emlakcepte.model.Realty;
import emlakcepte.model.User;
import emlakcepte.model.enums.RealtyType;
import emlakcepte.model.enums.UserType;
import emlakcepte.service.RealtyService;
import emlakcepte.service.UserService;

public class Main {

	public static void main(String[] args) {
		
		User userPelin = prepareUser("Pelin", "mimar@gmail.com", "Pelin1234");

		User userBeyza = new User("Beyza", "gamer@gmail.com", "12345678", UserType.INDIVIDUAL, null, null, null, null);
		
		
		UserService userService = new UserService();
		userService.createUser(userPelin);
		
		userService.createUser(userBeyza);
		
		// eklediğimiz userları yazdırma
		userService.printAllUsers();
		System.out.println();
		
		// userList.add(null);
		// userList.add(userPelin);
		
		// userList.forEach(usr -> System.out.println(usr.getName()));
		
		RealtyService realtyService = new RealtyService();
		
		
		Realty realty = new Realty( );
		realty.setNo(123L);
		realty.setTitle("Zekeriyaköy' de 1200 M2 Satılık Villa");
		realty.setStatus(RealtyType.ACTIVE);
		realty.setUser(userPelin);
		realty.setProvince("İstanbul");
		realty.setPublishedDate(LocalDateTime.now());
		realtyService.createRealty(realty);
		
		Realty realty1 = new Realty();
		realty1.setNo(124L);
		realty1.setTitle("Dörtyol Saat Meydanı'nda 250 M2 Satılık Daire");
		realty1.setStatus(RealtyType.ACTIVE);
		realty1.setUser(userBeyza);
		realty1.setProvince("Hatay");
		realtyService.createRealty(realty1);
		
		
		Realty favori1 = new Realty();
		favori1.setNo(126L);
		favori1.setTitle("Erzurum Dadaşkent'de 150 M2 Kiralık Daire");
		favori1.setStatus(RealtyType.PASSIVE);
		favori1.setUser(userBeyza);
		favori1.setProvince("Erzurum");
		realtyService.createRealty(favori1);
		
		userBeyza.setRealtyList(List.of(realty,realty1));
		
		List<Realty> favorilerim = new ArrayList<>();
		favorilerim.add(realty1);
		userBeyza.setFavoriteRealtyList(favorilerim);
		
		// Sistemdeki ilanlar
		System.out.println("\nBütün ilanlar : ");
		realtyService.getAll();
		
		// İstanbul, Ankara, İzmir ilanların bulunması
		System.out.println("\nİstanbuldaki ilan sayısı : ");
		realtyService.getAllByProvince("İstanbul");
		System.out.println("\nAnkaradaki ilan sayısı : ");
		realtyService.getAllByProvince("Ankara");
		System.out.println("\nİzmir ilan sayısı : ");
		realtyService.getAllByProvince("İzmir");
		
		// bir kullanıcının bütün ilanlarını listeleme
		realtyService.printAll(realtyService.getAllByUserName(userBeyza));
		
		
		realtyService.printAll(realtyService.getActiveAllByUserName(userPelin));
		/*
		userList.forEach(usr -> { 
			usr.getFavoriteRealtyList().forEach(favoriRealty -> 
				System.out.println(favoriRealty.getTitle())	
		);		
		});
		*/

		Message message = new Message("Acil dönüş!", "İlan ile ilgili daha fazla bilgi almak istiyorum.", userBeyza, userPelin);
		userBeyza.setMessages(List.of(message));
		// kullanıcının gönderdiği mesajlar
		userBeyza.getMessages(); 
		
		userPelin.setMessages(List.of(message));
		// kullanıcının gönderdiği mesajlar
		userPelin.getMessages(); 
	}

	
	private static User prepareUser(String name, String email, String password) {
		User user = new User();
		user.setName(name);
		user.setMail(email);
		user.setPassword(password);
		user.setType(UserType.INDIVIDUAL);
		user.setCreateDate(LocalDateTime.now());
		
		return user;
	}
}














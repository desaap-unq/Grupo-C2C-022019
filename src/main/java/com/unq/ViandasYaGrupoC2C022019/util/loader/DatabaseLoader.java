package com.unq.ViandasYaGrupoC2C022019.util.loader;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.unq.ViandasYaGrupoC2C022019.model.Business;
import com.unq.ViandasYaGrupoC2C022019.model.Client;
import com.unq.ViandasYaGrupoC2C022019.model.ImageModel;
import com.unq.ViandasYaGrupoC2C022019.model.Menu;
import com.unq.ViandasYaGrupoC2C022019.model.MenuCategory;
import com.unq.ViandasYaGrupoC2C022019.model.VirtualWallet;
import com.unq.ViandasYaGrupoC2C022019.persistence.BusinessRepository;
import com.unq.ViandasYaGrupoC2C022019.persistence.ClientRepository;
import com.unq.ViandasYaGrupoC2C022019.persistence.ImageRepository;
import com.unq.ViandasYaGrupoC2C022019.persistence.MenuRepository;
import com.unq.ViandasYaGrupoC2C022019.persistence.VirtualWalletRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private ClientRepository crepository;
	private VirtualWalletRepository vwrepository;
	private BusinessRepository brepository;
	private MenuRepository mrepository;
	private ImageRepository irepository;

	@Autowired
	public DatabaseLoader(ClientRepository crepository,
						 ImageRepository irepository,
						  VirtualWalletRepository vwrepository,
						  BusinessRepository brepository, 
						  MenuRepository mrepository) {
		this.crepository = crepository;
		this.vwrepository = vwrepository;
		this.brepository = brepository;
		this.mrepository = mrepository;
		this.irepository = irepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// Clean-up DB tables
		crepository.deleteAllInBatch();
		vwrepository.deleteAllInBatch();
		brepository.deleteAllInBatch();
		irepository.deleteAllInBatch();
		
		//=============================================
		
		Client client01 = new Client("Pomelo", "Rock", "prock@user.com", 15156205, "LaFuente 2123", "Soldati");
		VirtualWallet vwc = client01.getWallet();
		
		ClassPathResource imgfile = new ClassPathResource("images/nuevo-logo-mc-logo.jpg");
		byte[] pic = new byte[(int) imgfile.contentLength()];
		imgfile.getInputStream().read(pic);
		
		
		
		Business mcdonald = new Business("Mc Donald", "path logo", "Quilmes", 
								"Peatonal Rivadavia 112", "gmaps coord", 
								"Vendemos las mejores hamburguesas", "website", 
								"hamburguer@mcdonald.com", 15152659, "[08-23]", "LunADom", 
								"distance min - delivery");
		VirtualWallet vwm = mcdonald.getWallet();
		ImageModel mcimg = new ImageModel("nuevo-logo-mc-logo", "jpg", pic, mcdonald);
		
//		Business chavalpulperia = new Business("Chaval Pulperia", "path Logo", "Palermo", "Niceto Vega 4691",
//											"gmaps coord", "Cerveceria Artesanal", "website", "chaval@gmail.com", 
//											15487856, "[18-23]", "LunASab", "distance min - delivery");
//		VirtualWallet vwcp = chavalpulperia.getWallet();
//		
//		Business larumba = new Business("La Rumba", "path Logo", "Pompeya", "Av Saenz 1510", "gmaps coord", 
//										"La mejor comida casera", "website", "larumba@outlock.com", 
//										15231259, "[09-23]", "MarADom", "distance min - delivery");
//		VirtualWallet vwl = larumba.getWallet();
//		
//		Business senseirestaurant = new Business("Sensei Restaurant", "path Logo", "Lomas de Zamora", "Espania 398",
//												"gmaps coord", "Comida del medio oriente", "website", "sensei@yahoo.com", 
//												15569854, "[20-02]", "JueADom", "distance min - delivery");
//		VirtualWallet vws = senseirestaurant.getWallet();
//		
//		// LocalTime UTC-3
//		Menu mc_hamburger01 = new Menu("Doble Cuarto", "Doble carne, doble queso", Arrays.asList(MenuCategory.HAMBURGUESAS), 0d, LocalDate.now(), 
//										LocalDate.now(), LocalTime.of(21, 20), LocalTime.of(21, 20), 250d, 1, 10d, 2, 20d, 20, mcdonald);
//		Menu mc_hamburger02 = new Menu("TripleMc", "Triple carne, aderezo casero", Arrays.asList(MenuCategory.HAMBURGUESAS), 0d, LocalDate.now(), 
//										LocalDate.now(), LocalTime.of(21, 20), LocalTime.of(21, 20), 250d, 1, 10d, 2, 20d, 20, mcdonald);
//		
//		Menu chaval_cerveza01 = new Menu("Pakistan Pale", "Malta con cebada", Arrays.asList(MenuCategory.CERVEZA), 0d, LocalDate.now(), 
//				LocalDate.now(), LocalTime.of(21, 30), LocalTime.of(21, 25), 230d, 1, 10d, 2, 20d, 20, chavalpulperia);
//		Menu chaval_cerveza02 = new Menu("Red Ale", "Malta roja + lupulo", Arrays.asList(MenuCategory.CERVEZA), 0d, LocalDate.now(), 
//				LocalDate.now(), LocalTime.of(21, 20), LocalTime.of(21, 20), 250d, 1, 10d, 2, 20d, 20, chavalpulperia);
//		
//		Menu larumba_pizzas = new Menu("Pizza Grande jyq", "Pizza a la piedra", Arrays.asList(MenuCategory.PIZZA), 0d, LocalDate.now(), 
//				LocalDate.now(), LocalTime.of(21, 30), LocalTime.of(21, 25), 280d, 1, 10d, 2, 20d, 20, larumba);
//		Menu laruMenu_empanadas = new Menu("Empanada de Carne", "Carne cortada a cuchillo", Arrays.asList(MenuCategory.EMPANADAS), 0d, LocalDate.now(), 
//				LocalDate.now(), LocalTime.of(21, 20), LocalTime.of(21, 20), 310d, 1, 10d, 2, 20d, 20, larumba);
//
//		Menu sensei_cocinajaponesa01 = new Menu("Tempura Moriawase", "Fritura liviana de langostinos", Arrays.asList(MenuCategory.SUSHI), 0d, LocalDate.now(), 
//				LocalDate.now(), LocalTime.of(21, 30), LocalTime.of(21, 25), 320d, 1, 10d, 2, 20d, 20, senseirestaurant);
//		Menu sensei_cocinajaponesa02 = new Menu("Tori Teri", "Pollo marinado y laqueado", Arrays.asList(MenuCategory.SUSHI), 0d, LocalDate.now(), 
//				LocalDate.now(), LocalTime.of(21, 20), LocalTime.of(21, 20), 340d, 1, 10d, 2, 20d, 20, senseirestaurant);
		
		this.vwrepository.save(vwc);
		this.crepository.save(client01);
		
		// Business
		
		this.vwrepository.save(vwm);
		this.brepository.save(mcdonald);

//		this.vwrepository.save(vwcp);
//		this.brepository.save(chavalpulperia);
//		
//		this.vwrepository.save(vwl);
//		this.brepository.save(larumba);
//
//		this.vwrepository.save(vws);
//		this.brepository.save(senseirestaurant);
//		
//		// Menu
//		
//		this.mrepository.save(mc_hamburger01);
//		this.mrepository.save(mc_hamburger02);
//
//		this.mrepository.save(chaval_cerveza01);
//		this.mrepository.save(chaval_cerveza02);
//
//		this.mrepository.save(larumba_pizzas);
//		this.mrepository.save(laruMenu_empanadas);
//
//		this.mrepository.save(sensei_cocinajaponesa01);
//		this.mrepository.save(sensei_cocinajaponesa02);
		
		// Image
		
		this.irepository.save(mcimg);
	}

}

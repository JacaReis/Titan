package models.magics;
import models.creatures.Creature;

public class Protection extends Magic {

	private String description;
	
	public Protection() {
		super("Cria uma aura de invisibilidade ao seu redor. " +
			"Os elfos usam isso para, por exemplo, proteger suas aldeias. " +
			"Tome cuidado se o oponente estiver proximo a voce e dentro da aura, " +
			"pois ele sera capaz de ve-lo, mesmo que ambos estejam invisiveis.");
	}
	
	public String getDescription() {
		return description;
	}
	
	@Override
	public void use(Creature... creatures) {
		/// TODO Nothing
	}
	
}

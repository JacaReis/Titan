package models.itens;

public enum EnumItem {

	HabilityPotion(new HabilityPotion()),
	EnergyPotion(new EnergyPotion()),
	LuckPotion(new LuckPotion()),
	;
	
	private Item item;
	
	private EnumItem(Item item) {
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	}
}

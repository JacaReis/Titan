package models.dreamCreatures;

public enum EnumDreamCreature {

	FANTASMA_DA_NEVE(new FantasmaDaNeve(14)),
	MORCEGO_VAMPIRO(new MorcegoVampiro(16)),
	;
	
	private DreamCreature dreamCreature;
	
	private EnumDreamCreature(DreamCreature dreamCreature) {
		this.dreamCreature = dreamCreature;
	}
	
	private EnumDreamCreature(String name, int power) {
		this.dreamCreature = new DreamCreature(name, power);
	}
	
	public DreamCreature getCreature() {
		return this.dreamCreature;
	}
}

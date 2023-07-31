package douglas.lol.match.entityDTO;

public class ItemDTO {

	private Integer itemID;

	public ItemDTO(Integer itemID) {
		super();
		this.itemID = itemID;
	}

	public ItemDTO() {
		super();
	}

	public Integer getItemID() {
		return itemID;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}

	@Override
	public String toString() {
		return "ItemDTO [itemID=" + itemID + "]";
	}
}

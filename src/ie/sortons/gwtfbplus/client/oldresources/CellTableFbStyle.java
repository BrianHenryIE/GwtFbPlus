package ie.sortons.gwtfbplus.client.oldresources;


import com.google.gwt.user.cellview.client.CellTable;

public interface CellTableFbStyle extends CellTable.Resources
{
	  @Source({"CellTableFbStyle.css"})
	  TableStyle cellTableStyle();
	  
	  interface TableStyle extends CellTable.Style {
		  
		  String myReservationsContent();
		  String myReservationsContainer();
		  String myReservationsImage();
		  
	  }
	}

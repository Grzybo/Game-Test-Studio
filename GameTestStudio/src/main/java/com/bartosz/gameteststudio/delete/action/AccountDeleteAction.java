package com.bartosz.gameteststudio.delete.action;
 
import java.io.IOException;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.action.SecureAction;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Utils;

/**
 * Akcja odpowiada za usuwanie konta użytkownika z systemu.
 * @author Bartosz
 *
 */
@Action(value = "deleteAccount", //
results = { //
        @Result(name = "deleted", type="redirect", location = "/adminPage"), 
        @Result(name = "noPermissions",  type="redirect", location = "/noPermissions"), 
        @Result(name = "sessionExpired",  type="redirect", location = "/sessionExpired")
} //
)

public class AccountDeleteAction  extends SecureAction {

	private static final long serialVersionUID = 7475149545747929081L;
	private String itemID;

	/**
	 * Główna logika akcji.
	 */
	@Override
	public String executeSecured() throws GSException, NumberFormatException, IOException {

    	DataProvider.deleteUser(DataProvider.getUserByID(Long.parseLong(itemID)));
    	return "deleted";
	}

	/**
	 * Lista ról z dostępem do akcji.
	 */ 
	@Override
	protected Set<Long> allowedRolesID() {
		return Utils.setAllowedRolesID(this.getClass().getSimpleName());
	}
	
	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
}
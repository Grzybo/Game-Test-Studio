

console.log("U MNIE DZIALA");


function deleteConfirm(itemType, itemID) {
	console.log("item type = " + itemType); 
	switch(itemType) {
	    case "Bug":
			if (confirm("Are you sure you want to delete this Bug?")) var url = "/GameTestStudio/deleteBug?itemID="+ itemID;  
			else var url = "/GameTestStudio/editBug?itemID="+ itemID;
			break;
	    case "Test":
	    	if (confirm("Are you sure you want to delete this Test?")) var url = "/GameTestStudio/deleteTest?itemID="+ itemID;  
			else var url = "/GameTestStudio/editTest?itemID="+ itemID;
	    	break;
	    case "Area":
	    	if (confirm("Are you sure you want to delete this Area?")) var url = "/GameTestStudio/deleteArea?itemID="+ itemID;  
			else var url = "/GameTestStudio/editArea?itemID="+ itemID;
	    	break;
		case "Project":
	    	if (confirm("Are you sure you want to delete this Project?")) var url = "/GameTestStudio/deleteProject?itemID="+ itemID;  
			else var url = "/GameTestStudio/editProject?itemID="+ itemID;
	    	break;
		case "User":
	    	if (confirm("Are you sure you want to delete this Account?")) var url = "/GameTestStudio/deleteAccount?itemID="+ itemID;  
			else var url = "/GameTestStudio/editAccount?itemID="+ itemID;
	    	break;
	   }
	document.forms[0].action = url;
	document.forms[0].submit();
}

function test() {
	alert("U MNIE DZIALA");
}


console.log("U MNIE DZIALA");


function deleteConfirm(itemType, itemID) {
	console.log("item type = " + itemType); 
	switch(itemType) {
	    case "Bug":
			if (confirm("Are you sure you want to delete this Bug?")) var url = "/GameTestStudio/deleteBug?itemID="+ itemID;  
			else var url = "/GameTestStudio/editBug?itemID="+ itemID;
			break;
		case "BugFromProjects":
			if (confirm("Are you sure you want to delete this Bug?")) var url = "/GameTestStudio/deleteBug?itemID="+ itemID;  
			else var url = "/GameTestStudio/projects";
			break;
	    case "Test":
	    	if (confirm("Are you sure you want to delete this Test?")) var url = "/GameTestStudio/deleteTest?itemID="+ itemID;  
			else var url = "/GameTestStudio/editTest?itemID="+ itemID;
	    	break;
		case "TestFromProjects":
	    	if (confirm("Are you sure you want to delete this Test?")) var url = "/GameTestStudio/deleteTest?itemID="+ itemID;  
			else var url = "/GameTestStudio/projects";
	    	break;
	    case "Area":
	    	if (confirm("Are you sure you want to delete this Area?")) var url = "/GameTestStudio/deleteArea?itemID="+ itemID;  
			else var url = "/GameTestStudio/editArea?itemID="+ itemID;
	    	break;
		case "AreaFromProjects":
	    	if (confirm("Are you sure you want to delete this Area?")) var url = "/GameTestStudio/deleteArea?itemID="+ itemID;  
			else var url = "/GameTestStudio/projects";
	    	break;
		case "Project":
	    	if (confirm("Are you sure you want to delete this Project?")) var url = "/GameTestStudio/deleteProject?itemID="+ itemID;  
			else var url = "/GameTestStudio/editProject?itemID="+ itemID;
	    	break;
		case "ProjectFormAdmin":
	    	if (confirm("Are you sure you want to delete this Project?")) var url = "/GameTestStudio/deleteProject?itemID="+ itemID;  
			else var url = "/GameTestStudio/adminPage";
	    	break;
		case "User":
	    	if (confirm("Are you sure you want to delete this Account?")) var url = "/GameTestStudio/deleteAccount?itemID="+ itemID;  
			else var url = "/GameTestStudio/editAccount?itemID="+ itemID;
	    	break;
		case "UserFromAdmin":
	    	if (confirm("Are you sure you want to delete this Account?")) var url = "/GameTestStudio/deleteAccount?itemID="+ itemID;  
			else var url = "/GameTestStudio/adminPage";
	    	break;
		case "File":
	    	if (confirm("Are you sure you want to delete file from this Bug?")) var url = "/GameTestStudio/deleteAtt?itemID="+ itemID;  
			else var url = "/GameTestStudio/editBug?itemID="+ itemID;
	    	break;

	   }
	document.forms[0].action = url;
	document.forms[0].submit();
}

function test() {
	alert("U MNIE DZIALA");
}
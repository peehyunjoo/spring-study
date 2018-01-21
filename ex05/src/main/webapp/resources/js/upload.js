function checkImageType(fileName){
	var pattern = /jpg|gif|png|jpeg/i;
	
	return fileName.match(pattern);
}

function getFileInfo(fullName){
	var fileName, imgsrc, getLink;
	
	var fileLink;
	
	if(checkImageType(fullName)){
		imgsrc = "/displayFile?fileName="+ fullName;
		fileLink = fullName.substr(14);
		
		var front = fullName.substr(0,12);
		var end = fullName.substr(14);
		getLink ="/displayFile?fileName=" + front + end;
		
		console.log("getLink = " + getLink);
	}else{
		imgsrc = "/resources/dist/img/user3-128x128.jpg";
		fileLink = fullName.substr(12);s
		getLink = "/displayFile?fileName=" + fullName;
	}
	
	fileName = fileLink.substr(fileLink.indexOf("_")+1);
	
	return {fileName:fileName, imgsrc:imgsrc, getLink:getLink, fullName:fullName};
}
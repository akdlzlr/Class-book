//	자주쓰이는 함수 모음 스크립트파일!


//	대,소문자 상관 없이 정렬하는 함수
function compareIgnoreCase(left,right){
	var left2 = left.toLowerCase();
	var right2 = right.toLowerCase();
	if(left2<right2) return 1;
	if(left2>right2) return -1;
	return 0;
}


//	랜덤 함수
function random(range, start=0){
	return Math.floor(Math.random()*range+start);
}


//	단위변환
function formatSize(bytes, dm=2){
	if(bytes ==0) return '0B';
	var k =1000,
//		dm = decimalPoint || 2,
//			 decimalPoint가 0일 때, 뒤에 2가 들어간다? 오동작?
		sizes = ['B','K','M','G', 'T'],
		i=Math.floor(Math.log10(bytes)/Math.log10(k));
	return parseFloat((bytes/Math.pow(k,i)).toFixed(dm))+sizes[i];
}


//	배열 관련 prototype
Array.prototype.shuffle = function(){
	
	var arr = this.slice(0);
	
	for(var i =0; i<arr.length-1;i++){
		var ix = random(arr.length-(i+1));
		var temp=arr[ix];
		arr[ix]=arr[(arr.length-i-1)];
		arr[(arr.length-i-1)]=temp;	
//		swap(arr[ix],arr[(arr.length-i-1)]);
	}
	return arr;
}

Array.prototype.range = function(start,end){
	for(var i=start;i<end;i++){
		this.push(i);
	}
	return this;
}

// 날짜 & 시간 관련 prototype
Date.prototype.dateFormat = function(){
	var year = this.getFullYear();
	var month = this.getMonth()+1;
	var date = this.getDate();
	
	month = (month<10)?'0'+month : month;
	date = (date<10)? '0'+date : date;
	
	return `${year}-${month}-${date}`;
	
}

Date.prototype.timeFormat = function(){
	var hour = this.getHours();
	var minutes = this.getMinutes();
	var sec = this.getSeconds();
	
	hour =(hour<10)?'0'+hour:hour;
	minutes = (minutes<10)?'0'+minutes:minutes;
	sec = (sec<10)?'0'+sec:sec;
	return `${hour}:${minutes}:${sec}`;
}

function parseQuery() {
	var query = {};
	location.search.substr(1).split('&')
	.forEach(function(value){
		var tokens = value.split('=');
		query[tokens[0]] = tokens[1];
	});
	return query;
}

$(function() {
	$('.jumbotron').load('common/header.html');
	$('nav').load('common/menu.html');
	$('footer.myname').load('common/footer.html');
});

var images=[
	"images/Chrysanthemum.jpg",
	"images/Desert.jpg",
	"images/Koala.jpg",
	"images/Hydrangeas.jpg",
	"images/Penguins.jpg",
	"images/Tulips.jpg",
	"images/Jellyfish.jpg",
	"images/Lighthouse.jpg",
	"images/bird.jpg",
	"images/test.jpg",
	"images/test2.jpg"
];
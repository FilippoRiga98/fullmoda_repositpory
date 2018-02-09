$(document).ready(function() {
	if ($(".size-select").length) {
		$(".size-select").first().show();
	}
	
	//-- Click on QUANTITY
	$(".btn-minus").on("click",function(){
	    var now = $(".quantity > div > input").val();
	    if ($.isNumeric(now)){
	        if (parseInt(now) -1 > 0){ now--;}
	        $(".quantity > div > input").val(now);
	    }else{
	        $(".quantity > div > input").val("1");
	    }
	})            
	$(".btn-plus").on("click",function(){
	    var now = $(".quantity > div > input").val();
	    if ($.isNumeric(now)){
	        $(" .quantity > div > input").val(parseInt(now)+1);
	    }else{
	        $(".quantity > div > input").val("1");
	    }
	})                        
});

$(".color-select").change(function(elem){
	var selected = this.value;
	$(".size-select").hide();
	$("#sizesOf-"+selected).show();
	
});
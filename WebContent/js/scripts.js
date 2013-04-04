$.fn.imgdata = function(key){
	return this.find('.dataImg li:eq('+key+')').text();
}
$.fn.hdata = function(key){
	return this.find('.dataSet li:eq('+key+')').text();
}

$(document).ready(function(){	

	// tabs
	$("ul.tabs li").fadeIn(400); 
	$("ul.tabs li:first").addClass("active").fadeIn(400); 
	$(".tab_content:first").fadeIn(); 
	$("ul.tabs li").live('click',function() {
		  $("ul.tabs li").removeClass("active");						   
		  $(this).addClass("active");  
		  var activeTab = $(this).find("a").attr("href"); 
		  $('.tab_content').fadeOut();		
		  $(activeTab).delay(400).fadeIn();		
		  ResetForm();
		  return false;
	});
	
	
	//dataTable
	$('.data_table').dataTable({
		"sDom": 'f<"clear">rt<"clear">',
		"aaSorting": [],
		"aoColumns": [ { "bSortable": false },{ "bSortable": false } ]
	});
	$('.static').dataTable({
		"sDom": '',
		"aaSorting": [],
	  "aoColumns": [
					{ "bSortable": false },{ "bSortable": false },{ "bSortable": false },{ "bSortable": false },{ "bSortable": false }
	  ]
	});
	$('.data_table2').dataTable({
	"sDom": 'fCl<"clear">rtip',
	"sPaginationType": "full_numbers",
	 "aaSorting": [],
	  "aoColumns": [
					{ "bSortable": false },null,null,null,{ "bSortable": false }
	  ]
	});
	$('.data_table3').dataTable({
	"sDom": 'fCl<"clear">rtip',
	 "aaSorting": [],
	  "aoColumns": [
					{ "bSortable": false },null,null,null,{ "bSortable": false }
	  ]
	});
	
});	

$(function() {		
	  
  	//datepicker
	$("input.datepicker").datepicker({ 
		autoSize: true,
		appendText: '(dd-mm-yyyy)',
		dateFormat: 'dd-mm-yy'
	});
	$( "div.datepickerInline" ).datepicker({ 
		dateFormat: 'dd-mm-yy',
		numberOfMonths: 1
	});	

	$( "input.birthday" ).datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat:'yy-mm-dd'
    });
	

	//datetimepicker
   $("#datetimepicker").datetimepicker();
   $('#timepicker').timepicker({hourGrid: 4,
	minuteGrid: 15,
	ampm: true
	});
   $('#timepicker2').timepicker({hourGrid: 4,
	minuteGrid: 15,
	ampm: true
	});
   
   //button click
	$('.loading').live('click',function() { 
		  var str=$(this).attr('title'); 
		  var overlay=$(this).attr('rel'); 
		  loading(str,overlay);
		  setTimeout("unloading()",1500); 
	  });
	$('#preloader').live('click',function(){
			unloading();
	 });
	
	// submit form 
	$('a.submit_form').live('click',function(){
		  var form_id=$(this).parents('form').attr('id');
		  $("#"+form_id).submit();
	})	

	
	// uploadButton  ( Add file )
		$('#uploadButton').hover(function(){
			$('#upload_b').addClass('hover');
		},function(){
			$('#upload_b').removeClass('hover');
		});		
	
	// upload
	   $("input.fileupload").filestyle();
	
	
	// checkbox,selectbox customInput 
	 $('input[placeholder], textarea[placeholder]').placeholder();
	$('.ck,.chkbox,.checkAll ,input:radio').customInput();	
	$('.limit3m').limitInput({max:3,disablelabels:true});
	// select boxes
	$(function() {
        $('select').not("select.chzn-select,select[multiple],select#box1Storage,select#box2Storage").selectmenu({
            style: 'dropdown',
            transferClasses: true,
            width: null
        });
    });
	
	$(".dataTables_wrapper .dataTables_length select").addClass("small");
	$("table tbody tr td:first-child .custom-checkbox:first-child").css("margin: 0px 3px 3px 3px");
	 // mutiselection
	$(".chzn-select").chosen(); 
	// checkbox iphoneStyle
	$(".on_off_checkbox").iphoneStyle(); 
	$(".show_email").iphoneStyle({
		  checkedLabel: "show Email",
		  uncheckedLabel: "Don't show ",
		  labelWidth:'85px'
	}); 
	$(".preOrder").iphoneStyle({
		  checkedLabel: "in stocks",
		  uncheckedLabel: "out stocks",
		  labelWidth:'76px'
	}); 
	$(".online").iphoneStyle({
		  checkedLabel: "online",
		  uncheckedLabel: "offline ",
		  labelWidth:'55px'
	});
	/*$(".approve").iphoneStyle({
		  checkedLabel: "Approve",
		  uncheckedLabel: "Disapprove ",
		  labelWidth:'75px',
		  onChange: function(){
			  var check = $(".approve").attr('checked');
			  if(check){
				  alert("approve");
			  }else{
				alert("disapprove");  
			  }
		  }
	}); */
	$(".show_conmap").iphoneStyle({
		  checkedLabel: "show map",
		  uncheckedLabel: "Don't show ",
		  labelWidth:'85px',
		  onChange: function() {
				var chek=$(".show_conmap").attr('checked');
					  if(chek){
						  //$(".disabled_map").fadeOut();
					  }else{
						 //$(".disabled_map").fadeIn();
					  }
		}
	});


	 // checkbox  All in Table
	$(".checkAll").live('click',function(){
		  var table=$(this).parents('table').attr('id');
		  var checkedStatus = this.checked;
		  var id= this.id;
		 $( "table#"+table+" tbody tr td:first-child input:checkbox").each(function() {
			this.checked = checkedStatus;
				if (this.checked) {
					$(this).attr('checked', $('.' + id).is(':checked'));
					$('label[for='+$(this).attr('id')+']').addClass('checked ');
				}else{
					$(this).attr('checked', $('.' + id).is(''));
					$('label[for='+$(this).attr('id')+']').removeClass('checked ');
					}
		});	 
	});		
	

	// icon  gray Hover
	$('.iconBox.gray').hover(function(){
		  var name=$(this).find('img').attr('alt');
		  $(this).find('img').animate({ opacity: 0.5 }, 0, function(){
			    $(this).attr('src','images/icon/color_18/'+name+'.png').animate({ opacity: 1 }, 700);									 
		 });
	},function(){
		  var name=$(this).find('img').attr('alt');
		  $(this).find('img').attr('src','images/icon/gray_18/'+name+'.png');
	 })
	// icon  Logout 
	$('div.logout').hover(function(){
		  var name=$(this).find('img').attr('alt');
		  $(this).find('img').animate({ opacity: 0.4 }, 200, function(){
			    $(this).attr('src','images/'+name+'.png').animate({ opacity: 1 }, 500);									 
		 });
	},function(){
		  var name=$(this).find('img').attr('name');
		  $(this).find('img').animate({ opacity: 0.5 }, 200, function(){
			    $(this).attr('src','images/'+name+'.png').animate({ opacity: 1 }, 500);									 
		 });
	 })
	// icon  setting 
	$('div.setting').hover(function(){
		$(this).find('img').addClass('gearhover');
	},function(){
		$(this).find('img').removeClass('gearhover');
	 })
	
		

$('.main_menu li').live({
        mouseenter: function(){
			//$('#main_menu li ').find('ul').hide();
		   $(this).find('ul').show();
           },
        mouseleave: function(){
		 $(this).find('ul').hide();
           }
       }
    );



	// hide notify  Message with click
	$('#alertMessage').live('click',function(){
	  $(this).stop(true,true).animate({ opacity: 0,right: '-20'}, 500,function(){ $(this).hide(); });						 
	});
	
	


	// Confirm Delete.
	$(".Delete").live('click',function() { 
		  var row=$(this).parents('tr');
		  var dataSet=$(this).parents('form');
		  var id = $(this).attr("id");
		  var name = $(this).attr("name");
		  var data ='id='+id;
		  Delete(data,name,row,0,dataSet);
	});
	$(".DeleteAll").live('click',function() {			
		  var rel=$(this).attr('rel');	
		  var row=$(this).parents('.tab_content').attr('id');	
		  var row=row+' .load_page ';
		  if(!rel) { 
			  var rel=0;
			  var row=$('#load_data').attr('id');	 
		  }  
		  var dataSet=$('form:eq('+rel+')');					   
		  var	data=$('form:eq('+rel+')').serialize();
		  var name = 'All File Select';
		 Delete(data,name,row,2,dataSet);
	});
	
	$('.state-available').live('click', function(){
			$(".tablecontainerrow .state-select").html('Available');										 
			$(".tablecontainerrow div").removeClass('state-select');
			$(this).addClass('state-select');
			$(this).html('Selected');
			var selectdtime = $(this).attr("id");
			//alert(selectdtime);
			$("#selectedtime").attr("value",selectdtime);
	 	});	
	$('.services_list .ck').live('click', function(){
		$('.services_list div').removeClass('activestf');
		$(this).parents('div.staff_pro').addClass('activestf');										  
	});

    	
	});		


	// check browser fixbug
	var mybrowser=navigator.userAgent;
	if(mybrowser.indexOf('MSIE')>0){$(function() {	
			   $('.formEl_b fieldset').css('padding-top', '0');
				$('div.section label small').css('font-size', '10px');
				$('div.section  div .select_box').css({'margin-left':'-5px'});
				$('.iPhoneCheckContainer label').css({'padding-top':'6px'});
				$('.uibutton').css({'padding-top':'6px'});
				$('.uibutton.icon:before').css({'top':'1px'});
				$('.dataTables_wrapper .dataTables_length ').css({'margin-bottom':'10px'});
		});
	}
	if(mybrowser.indexOf('Firefox')>0){ $(function() {	
			   $('.formEl_b fieldset  legend').css('margin-bottom', '0px');	
			   $('table .custom-checkbox label').css('left', '3px');
		  });
	}	
	if(mybrowser.indexOf('Presto')>0){
		$('select').css('padding-top', '8px');
	}
	if(mybrowser.indexOf('Chrome')>0){$(function() {	
				 $('div.tab_content  ul.uibutton-group').css('margin-top', '-40px');
				  $('div.section  div .select_box').css({'margin-top':'0px','margin-left':'-2px'});
				  $('select').css('padding', '6px');
				  $('table .custom-checkbox label').css('left', '3px');
		});
	}		
	if(mybrowser.indexOf('Safari')>0){}		



		  
function Delete(data,name,row,type,dataSet){
		var loadpage = dataSet.hdata(0);
		var url = dataSet.hdata(1);
		var table = dataSet.hdata(2);
		var data = data+"&tabel="+table;
$.confirm({
'title': '_DELETE DIALOG BOX','message': " <strong>YOU WANT TO DELETE </strong><br /><font color=red>' "+ name +" ' </font> ",'buttons': {'Yes': {'class': 'special',
'action': function(){
			loading('Checking');
							 $('#preloader').html('Deleting...');
							 if(type==0){ row.slideUp(function(){   showSuccess('Success',5000); unloading(); }); return false;}
							  if(type==1){ row.slideUp(function(){   showSuccess('Success',5000); unloading(); }); return false;}
								setTimeout("unloading();",900); 		 
				 }},'No'	: {'class'	: ''}}});}

	  function albumDelete(data,name,dataSet){
			  var loadpage = dataSet.hdata(0);
			  var row = dataSet.hdata(2);
			  $.confirm({
			  'title': '_DELETE DIALOG BOX','message': "<strong>YOU WANT TO DELETE </strong><br /><font color=red>' "+ name +" ' </font> ",'buttons': {'Yes': {'class': 'special',
			  'action': function(){
						  loading('Checking',1);
						  setTimeout("unloading()",1500); 	  
				}},'No'	: {'class'	: ''}}});
	  }
	  
	 
	  function ResetForm(){
		  $('form').each(function(index) {	  
			var form_id=$('form:eq('+index+')').attr('id');
				  if(form_id){ 
					  $('#'+form_id).get(0).reset(); 
					  $('#'+form_id).validationEngine('hideAll');
							  var editor=$('#'+form_id).find('#editor').attr('id');
							  if(editor){
								   $('#editor').cleditor()[0].clear();
							  }
				  } 
		  });	
	  }


	  
	  function showError(str,delay){	
		  if(delay){
			  $('#alertMessage').removeClass('success info warning').addClass('error').html(str).stop(true,true).show().animate({ opacity: 1,right: '10'}, 500,function(){
					  $(this).delay(delay).animate({ opacity: 0,right: '-20'}, 500,function(){ $(this).hide(); });																														   																											
				});
			  return false;
		  }
			  	$('#alertMessage').addClass('error').html(str).stop(true,true).show().animate({ opacity: 1,right: '10'}, 500);	
	  }
	  function showSuccess(str,delay){
		  if(delay){
			  $('#alertMessage').removeClass('error info warning').addClass('success').html(str).stop(true,true).show().animate({ opacity: 1,right: '10'}, 500,function(){
					  $(this).delay(delay).animate({ opacity: 0,right: '-20'}, 500,function(){ $(this).hide(); });																														   																											
				});
			  return false;
		  }
			  $('#alertMessage').addClass('success').html(str).stop(true,true).show().animate({ opacity: 1,right: '10'}, 500);	
	  }
	  function showWarning(str,delay){
		  if(delay){
			  $('#alertMessage').removeClass('error success  info').addClass('warning').html(str).stop(true,true).show().animate({ opacity: 1,right: '10'}, 500,function(){
					  $(this).delay(delay).animate({ opacity: 0,right: '-20'}, 500,function(){ $(this).hide(); });																														   																											
				});
			  return false;
		  }
			  $('#alertMessage').addClass('warning').html(str).stop(true,true).show().animate({ opacity: 1,right: '10'}, 500);	
	  }
	  function showInfo(str,delay){
		  if(delay){
			  $('#alertMessage').removeClass('error success  warning').html(str).stop(true,true).show().animate({ opacity: 1,right: '10'}, 500,function(){
					  $(this).delay(delay).animate({ opacity: 0,right: '-20'}, 500,function(){ $(this).hide(); });																														   																											
				});
			  return false;
		  }
			  $('#alertMessage').html(str).stop(true,true).show().animate({ opacity: 1,right: '10'}, 500);	
	  }

function loading(name,overlay) { 
			$('body').append('<div id="overlay"></div><div id="preloader">'+name+'..</div>');
					if(overlay==1){
					  $('#overlay').css('opacity',0.4).fadeIn(400,function(){  $('#preloader').fadeIn(400);	});
					  return  false;
			   }
			$('#preloader').fadeIn();	  
	   }
	   
	   
	  function unloading() { 
			$('#preloader').fadeOut(400,function(){ $('#overlay').fadeOut(); $.fancybox.close(); }).remove();
	   }

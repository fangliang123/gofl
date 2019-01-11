var prefix = "/sys/user";

var grid_table = "#userGridTable";
var grid_pager = "#gridPager";

var grid_data =
    [
        {id:"1",name:"Desktop Computer",note:"note",stock:"Yes",ship:"FedEx", sdate:"2007-12-03"},
        {id:"2",name:"Laptop",note:"Long text ",stock:"Yes",ship:"InTime",sdate:"2007-12-03"},
        {id:"3",name:"LCD Monitor",note:"note3",stock:"Yes",ship:"TNT",sdate:"2007-12-03"},
        {id:"4",name:"Speakers",note:"note",stock:"No",ship:"ARAMEX",sdate:"2007-12-03"},
        {id:"5",name:"Laser Printer",note:"note2",stock:"Yes",ship:"FedEx",sdate:"2007-12-03"},
        {id:"6",name:"Play Station",note:"note3",stock:"No", ship:"FedEx",sdate:"2007-12-03"},
        {id:"7",name:"Mobile Telephone",note:"note",stock:"Yes",ship:"ARAMEX",sdate:"2007-12-03"},
        {id:"8",name:"Server",note:"note2",stock:"Yes",ship:"TNT",sdate:"2007-12-03"},
        {id:"9",name:"Matrix Printer",note:"note3",stock:"No", ship:"FedEx",sdate:"2007-12-03"},
        {id:"10",name:"Desktop Computer",note:"note",stock:"Yes",ship:"FedEx", sdate:"2007-12-03"},
        {id:"11",name:"Laptop",note:"Long text ",stock:"Yes",ship:"InTime",sdate:"2007-12-03"},
        {id:"12",name:"LCD Monitor",note:"note3",stock:"Yes",ship:"TNT",sdate:"2007-12-03"},
        {id:"13",name:"Speakers",note:"note",stock:"No",ship:"ARAMEX",sdate:"2007-12-03"},
        {id:"14",name:"Laser Printer",note:"note2",stock:"Yes",ship:"FedEx",sdate:"2007-12-03"},
        {id:"15",name:"Play Station",note:"note3",stock:"No", ship:"FedEx",sdate:"2007-12-03"},
        {id:"16",name:"Mobile Telephone",note:"note",stock:"Yes",ship:"ARAMEX",sdate:"2007-12-03"},
        {id:"17",name:"Server",note:"note2",stock:"Yes",ship:"TNT",sdate:"2007-12-03"},
        {id:"18",name:"Matrix Printer",note:"note3",stock:"No", ship:"FedEx",sdate:"2007-12-03"},
        {id:"19",name:"Matrix Printer",note:"note3",stock:"No", ship:"FedEx",sdate:"2007-12-03"},
        {id:"20",name:"Desktop Computer",note:"note",stock:"Yes",ship:"FedEx", sdate:"2007-12-03"},
        {id:"21",name:"Laptop",note:"Long text ",stock:"Yes",ship:"InTime",sdate:"2007-12-03"},
        {id:"22",name:"LCD Monitor",note:"note3",stock:"Yes",ship:"TNT",sdate:"2007-12-03"},
        {id:"23",name:"Speakers",note:"note",stock:"No",ship:"ARAMEX",sdate:"2007-12-03"}
    ];

var subgrid_data =
    [
        {id:"1", name:"sub grid item 1", qty: 11},
        {id:"2", name:"sub grid item 2", qty: 3},
        {id:"3", name:"sub grid item 3", qty: 12},
        {id:"4", name:"sub grid item 4", qty: 5},
        {id:"5", name:"sub grid item 5", qty: 2},
        {id:"6", name:"sub grid item 6", qty: 9},
        {id:"7", name:"sub grid item 7", qty: 3},
        {id:"8", name:"sub grid item 8", qty: 8}
    ];

$(document).ready(function () {
    loadUserList();
    initTreeData();
});

function loadUserList() {
    $(grid_table).jqGrid({
        subGrid: true,
        subGridOptions: {
            plusicon: "ace-icon fa fa-plus center bigger-110 blue",
            minusicon: "ace-icon fa fa-minus center bigger-110 blue",
            openicon: "ace-icon fa fa-chevron-right center orange"
        },
        data: grid_data,
        datatype: "local",
        height: 300,
        // height: function () {
        //     var height = $(window).height - $(".main-header").height -
        //         $(".main-footer").height - $("div.box-header").height -
        //         $("#searchForm").height - 120;
        //     alert(height);
        //     return height;
        // },
        colNames:['ID','Last Sales','Name', 'Stock', 'Ship via','Notes', '  '],
        colModel:[
            {name:'id',index:'id', width:60, sorttype:"int", editable: true},
            {name:'sdate',index:'sdate',width:90, editable:true, sorttype:"date",unformat: pickDate},
            {name:'name',index:'name', width:150,editable: true,editoptions:{size:"20",maxlength:"30"}},
            {name:'stock',index:'stock', width:70, editable: true,edittype:"checkbox",editoptions: {value:"Yes:No"},unformat: aceSwitch},
            {name:'ship',index:'ship', width:90, editable: true,edittype:"select",editoptions:{value:"FE:FedEx;IN:InTime;TN:TNT;AR:ARAMEX"}},
            {name:'note',index:'note', width:150, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"10"}},
            {name:'myac',index:'', width:80, fixed:true, sortable:false, resize:false,
                formatter:'actions',
                formatoptions:{
                    keys:true,
                    //delbutton: false,//disable delete button

                    delOptions:{recreateForm: true, beforeShowForm:beforeDeleteCallback},
                    //editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
                }
            }
        ],
        viewrecords: true,
        rowNum:10,
        rowList:[10,20,30],
        pager : grid_pager,
        altRows: true,
        multiselect: true,
        //multikey: "ctrlKey",
        multiboxonly: true,
        // caption: "User List"

        loadComplete : function() {
            var table = this;
            setTimeout(function(){
                styleCheckbox(table);

                // updateActionIcons(table);
                updatePagerIcons(table);
                enableTooltips(table);
            }, 0);
        },
        // editurl: "./dummy.php",//nothing is saved
        // caption: "jqGrid with inline editing"

        // url         :   prefix+'/listData',
        // datatype    :   'json',
    });

    jQuery(grid_table).jqGrid('navGrid',grid_pager,
        { 	//navbar options
            edit: false,
            editicon : 'ace-icon fa fa-pencil blue',
            add: false,
            addicon : 'ace-icon fa fa-plus-circle purple',
            del: false,
            delicon : 'ace-icon fa fa-trash-o red',
            search: false,
            searchicon : 'ace-icon fa fa-search orange',
            refresh: false,
            refreshicon : 'ace-icon fa fa-refresh green',
            view: false,
            viewicon : 'ace-icon fa fa-search-plus grey',
        }
    );
}

function beforeDeleteCallback(e) {
    var form = $(e[0]);
    if(form.data('styled')) return false;

    form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
    // style_delete_form(form);

    form.data('styled', true);
}

//enable datepicker
function pickDate( cellvalue, options, cell ) {
    setTimeout(function(){
        $(cell) .find('input[type=text]')
            .datepicker({format:'yyyy-mm-dd' , autoclose:true});
    }, 0);
}

//switch element when editing inline
function aceSwitch( cellvalue, options, cell ) {
    setTimeout(function(){
        $(cell) .find('input[type=checkbox]')
            .addClass('ace ace-switch ace-switch-5')
            .after('<span class="lbl"></span>');
    }, 0);
}

function styleCheckbox(table) {
    /**
     $(table).find('input:checkbox').addClass('ace')
     .wrap('<label />')
     .after('<span class="lbl align-top" />')


     $('.ui-jqgrid-labels th[id*="_cb"]:first-child')
     .find('input.cbox[type=checkbox]').addClass('ace')
     .wrap('<label />').after('<span class="lbl align-top" />');
     */
}

function updatePagerIcons(table) {
    var replacement =
        {
            'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
            'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
            'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
            'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
        };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

        if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
    })
}

function enableTooltips(table) {
    $('.navtable .ui-pg-button').tooltip({container:'body'});
    $(table).find('.ui-pg-div').tooltip({container:'body'});
}

//var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');

$(document).one('ajaxloadstart.page', function(e) {
    $.jgrid.gridDestroy(grid_selector);
    $('.ui-jqdialog').remove();
});


/*
* ********************************************
*           Tree Show
* ********************************************
* */

var simpleData = treeData();

function initTreeData() {
    $("#tree2").ace_tree({
        dataSource: simpleData['dataSource2'] ,
        loadingHTML:'<div class="tree-loading"><i class="ace-icon fa fa-refresh fa-spin blue"></i></div>',
        'open-icon' : 'ace-icon fa fa-folder-open',
        'close-icon' : 'ace-icon fa fa-folder',
        'itemSelect' : true,
        'folderSelect': true,
        'multiSelect': true,
        'selected-icon' : null,
        'unselected-icon' : null,
        'folder-open-icon' : 'ace-icon tree-plus',
        'folder-close-icon' : 'ace-icon tree-minus'
    });
}

function treeData() {
    var tree_data_2 = {
        'pictures' : {text: 'Pictures', type: 'folder', 'icon-class':'red'}	,
        'music' : {text: 'Music', type: 'folder', 'icon-class':'orange'}	,
        'video' : {text: 'Video', type: 'folder', 'icon-class':'blue'}	,
        'documents' : {text: 'Documents', type: 'folder', 'icon-class':'green'}	,
        'backup' : {text: 'Backup', type: 'folder'}	,
        'readme' : {text: '<i class="ace-icon fa fa-file-text grey"></i> ReadMe.txt', type: 'item'},
        'manual' : {text: '<i class="ace-icon fa fa-book blue"></i> Manual.html', type: 'item'}
    }
    tree_data_2['music']['additionalParameters'] = {
        'children' : [
            {text: '<i class="ace-icon fa fa-music blue"></i> song1.ogg', type: 'item'},
            {text: '<i class="ace-icon fa fa-music blue"></i> song2.ogg', type: 'item'},
            {text: '<i class="ace-icon fa fa-music blue"></i> song3.ogg', type: 'item'},
            {text: '<i class="ace-icon fa fa-music blue"></i> song4.ogg', type: 'item'},
            {text: '<i class="ace-icon fa fa-music blue"></i> song5.ogg', type: 'item'}
        ]
    }
    tree_data_2['video']['additionalParameters'] = {
        'children' : [
            {text: '<i class="ace-icon fa fa-film blue"></i> movie1.avi', type: 'item'},
            {text: '<i class="ace-icon fa fa-film blue"></i> movie2.avi', type: 'item'},
            {text: '<i class="ace-icon fa fa-film blue"></i> movie3.avi', type: 'item'},
            {text: '<i class="ace-icon fa fa-film blue"></i> movie4.avi', type: 'item'},
            {text: '<i class="ace-icon fa fa-film blue"></i> movie5.avi', type: 'item'}
        ]
    }
    tree_data_2['pictures']['additionalParameters'] = {
        'children' : {
            'wallpapers' : {text: 'Wallpapers', type: 'folder', 'icon-class':'pink'},
            'camera' : {text: 'Camera', type: 'folder', 'icon-class':'pink'}
        }
    }
    tree_data_2['pictures']['additionalParameters']['children']['wallpapers']['additionalParameters'] = {
        'children' : [
            {text: '<i class="ace-icon fa fa-picture-o green"></i> wallpaper1.jpg', type: 'item'},
            {text: '<i class="ace-icon fa fa-picture-o green"></i> wallpaper2.jpg', type: 'item'},
            {text: '<i class="ace-icon fa fa-picture-o green"></i> wallpaper3.jpg', type: 'item'},
            {text: '<i class="ace-icon fa fa-picture-o green"></i> wallpaper4.jpg', type: 'item'}
        ]
    }
    tree_data_2['pictures']['additionalParameters']['children']['camera']['additionalParameters'] = {
        'children' : [
            {text: '<i class="ace-icon fa fa-picture-o green"></i> photo1.jpg', type: 'item'},
            {text: '<i class="ace-icon fa fa-picture-o green"></i> photo2.jpg', type: 'item'},
            {text: '<i class="ace-icon fa fa-picture-o green"></i> photo3.jpg', type: 'item'},
            {text: '<i class="ace-icon fa fa-picture-o green"></i> photo4.jpg', type: 'item'},
            {text: '<i class="ace-icon fa fa-picture-o green"></i> photo5.jpg', type: 'item'},
            {text: '<i class="ace-icon fa fa-picture-o green"></i> photo6.jpg', type: 'item'}
        ]
    }


    tree_data_2['documents']['additionalParameters'] = {
        'children' : [
            {text: '<i class="ace-icon fa fa-file-text red"></i> document1.pdf', type: 'item'},
            {text: '<i class="ace-icon fa fa-file-text grey"></i> document2.doc', type: 'item'},
            {text: '<i class="ace-icon fa fa-file-text grey"></i> document3.doc', type: 'item'},
            {text: '<i class="ace-icon fa fa-file-text red"></i> document4.pdf', type: 'item'},
            {text: '<i class="ace-icon fa fa-file-text grey"></i> document5.doc', type: 'item'}
        ]
    }

    tree_data_2['backup']['additionalParameters'] = {
        'children' : [
            {text: '<i class="ace-icon fa fa-archive brown"></i> backup1.zip', type: 'item'},
            {text: '<i class="ace-icon fa fa-archive brown"></i> backup2.zip', type: 'item'},
            {text: '<i class="ace-icon fa fa-archive brown"></i> backup3.zip', type: 'item'},
            {text: '<i class="ace-icon fa fa-archive brown"></i> backup4.zip', type: 'item'}
        ]
    }

    var dataSource2 = function(options, callback){
        var $data = null
        if(!("text" in options) && !("type" in options)){
            $data = tree_data_2;//the root tree
            callback({ data: $data });
            return;
        }
        else if("type" in options && options.type == "folder") {
            if("additionalParameters" in options && "children" in options.additionalParameters)
                $data = options.additionalParameters.children || {};
            else $data = {}//no data
        }

        if($data != null)//this setTimeout is only for mimicking some random delay
            setTimeout(function(){callback({ data: $data });} , parseInt(Math.random() * 500) + 200);

        //we have used static data here
        //but you can retrieve your data dynamically from a server using ajax call
        //checkout examples/treeview.html and examples/treeview.js for more info
    }

    return {'dataSource2' : dataSource2} ;
}



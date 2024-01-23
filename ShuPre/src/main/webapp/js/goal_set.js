//
var num_materials = 1;

function addForm() {
	//テンプレートからリストアイテムを複製
	const template = document.getElementById("formTemplate");
	const newItem = template.content.cloneNode(true);
	
	console.log("add-button pushed");
	
	if (newItem) {

		// 子要素を指定しname属性の値を変更
	    newItem.querySelector('#materialId_').name = 'materialId_' + num_materials;
	    newItem.querySelector('#pageStart_').name = 'pageStart_' + num_materials;
	    newItem.querySelector('#pageEnd_').name = 'pageEnd_' + num_materials;
	    
	    // 子要素を指定しid属性の値を変更
	    newItem.querySelector('#materialId_').id = 'materialId_' + num_materials;
	    newItem.querySelector('#pageStart_').id = 'pageStart_' + num_materials;
	    newItem.querySelector('#pageEnd_').id = 'pageEnd_' + num_materials;
	    newItem.querySelector('#formItem_').id = 'formItem_' + num_materials;
	
	    // 新しいリストアイテムを追加
	    document.getElementById('formList').appendChild(newItem);
	    
	    num_materials++;
	    
	    // hidden属性をもつinputタグのvalueにitem数を設定
	    const inputNum = document.getElementById('num_materials');
	    inputNum.value = num_materials;
	    
	    console.log('item added!')
	    console.log('num:' + num_materials);
	} else {
	    console.error("Could not find element with ID 'formItem_'");
	}
    
};


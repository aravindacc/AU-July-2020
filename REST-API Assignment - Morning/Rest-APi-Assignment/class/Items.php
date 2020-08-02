<?php
class Items{   
    
    private $itemsTable = "items";      
    public $id;
    public $name;
    public $description;
    public $status;
    public $category_id;   
    public $created; 
	public $modified; 
    private $conn;
	
    public function __construct($db){
        $this->conn = $db;
    }	
	
	function read(){	
		if($this->id) {
			$stmt = $this->conn->prepare("SELECT * FROM ".$this->itemsTable." WHERE id = ?");
			$stmt->bind_param("i", $this->id);					
		} else {
			$stmt = $this->conn->prepare("SELECT * FROM ".$this->itemsTable);		
		}		
		$stmt->execute();			
		$result = $stmt->get_result();		
		return $result;	
	}
	
	function create(){
		
		$stmt = $this->conn->prepare("
			INSERT INTO ".$this->itemsTable."(`id`,`description`, `status`) VALUES(?,?,?)");
		$this->description = htmlspecialchars(strip_tags($this->description));
		$this->status = htmlspecialchars(strip_tags($this->status));
        $this->id = htmlspecialchars(strip_tags($this->id));
		
		$stmt->bind_param("iss",$this->id,$this->description,$this->status);
		
		if($stmt->execute()){
			return true;
		}
	 
		return false;		 
	}
		
	function update(){
	 
		$stmt = $this->conn->prepare("
			UPDATE ".$this->itemsTable." 
			SET description = ?, status = ?
			WHERE id = ?");
	 
		$this->id = htmlspecialchars(strip_tags($this->id));
			$this->description = htmlspecialchars(strip_tags($this->description));
		$this->status = htmlspecialchars(strip_tags($this->status));
		 
		$stmt->bind_param("ssi",  $this->description, $this->status,$this->id);
		
		if($stmt->execute()){
			return true;
		}
	 
		return false;
	}
	
	function delete(){
		
		$stmt = $this->conn->prepare("
			DELETE FROM ".$this->itemsTable." 
			WHERE id = ?");
			
		$this->id = htmlspecialchars(strip_tags($this->id));
	 
		$stmt->bind_param("i", $this->id);
	 
		if($stmt->execute()){
			return true;
		}
	 
		return false;		 
	}
}
?>
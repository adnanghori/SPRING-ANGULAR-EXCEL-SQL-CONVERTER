import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css']
})
export class FileUploadComponent implements OnInit {
  url = "http://localhost:8080/product/file";
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    
  }
  file:any;
  flag= true;
  
  selectFile(event:any){
    this.file = event.target.files[0];
    console.log(this.file);
    
  }
  uploadFile(){ 
    let formData = new FormData();
    formData.append("file",this.file);
    this.flag=false;
    this.http.post(this.url,formData).subscribe(
      (data:any)=>{
        this.flag = true;
        alert(data.message)
        
      },
    (error)=>{
      this.flag = true;
      alert(error.message)
    }
    );
  }
}

import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormsModule } from '@angular/forms';
import { SessionStorageService } from 'angular-web-storage';
import { MatDialogRef } from '@angular/material/dialog';
import { CommonService } from '../common.service';

@Component({
  selector: 'app-form-comp',
  templateUrl: './form-comp.component.html',
  styleUrls: ['./form-comp.component.scss']
})

export class FormCompComponent implements OnInit {
  profileForm = this.fb.group({
    empId: ['', [Validators.required, Validators.pattern("^[0-9]*$"), Validators.maxLength(2)]],
    firstName: ['',[Validators.required, Validators.pattern("^[a-zA-Z]*$"), Validators.maxLength(20)]],
    lastName: ['', [Validators.required, Validators.pattern("^[a-zA-Z]*$"), Validators.maxLength(20)]],
    age: [''],
    city: ['']
  });

  itemInput = {
    empId: "",
    firstName: "",
    lastName: "",
    age: "",
    city: ""
  };

  constructor(private fb: FormBuilder,
    public service: CommonService, 
    public dialogRef: MatDialogRef<FormCompComponent>,
    private session: SessionStorageService) { }

  ngOnInit(): void {
  }

  onClose() {
    this.service.form.reset();
    this.service.initializeFormGroup();
    this.dialogRef.close();
  }

  onSubmit() {
    console.log(this.itemInput.empId);
    console.log("on submit");

    if (this.service.form.value) {
      if (this.service.form.value.empId === 0){
        this.service.insertEmployee(this.itemInput);
      }
      else
        this.service.updateEmployee(this.itemInput);
      this.service.form.reset();
      // this.service.initializeFormGroup();
      alert('Submitted successfully');
      this.onClose();
    }
  }

}

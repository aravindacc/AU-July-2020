import { Component, Inject, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { SessionStorageService } from 'angular-web-storage';
// import { EmitType } from '@syncfusion/ej2-base';
// import { UploaderComponent } from '@syncfusion/ej2-angular-inputs';
// import { DialogComponent } from '@syncfusion/ej2-angular-popups';

// import { TableCompComponent } from '../table-comp/table-comp.component';

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
  private formSubmitAttempt: boolean;

  // tableCompComponent = new TableCompComponent(this.session);

  constructor(private fb: FormBuilder, private session: SessionStorageService) { }

  ngOnInit(): void {
  }

  updateProfile() {
    this.profileForm.patchValue({
      firstName: 'Nancy',
      address: {
        street: '123 Drew Street'
      }
    });
  }

  onSubmit() {
    this.formSubmitAttempt = true;
    let dataForm = {};
    dataForm = this.profileForm.value;
    // this.validateAllFormFields(this.profileForm.value);
    // this.tableCompComponent.addInTable(dataForm);
  }

  openForm() {
    document.getElementById("myForm").style.display = "block";
  }
  
  closeForm() {
    document.getElementById("myForm").style.display = "none";
  }

  // isFieldValid(field: string) {
  //   console.log("field valid");
  //   return ((!this.profileForm.get(field).valid && this.profileForm.get(field).touched) ||
  //   (this.profileForm.get(field).untouched && this.formSubmitAttempt));
  // }

  // validateAllFormFields(formGroup: FormGroup) {
  //   console.log("validate all fields");
  //   Object.keys(formGroup.controls).forEach(field => {
  //     const control = formGroup.get(field);
  //     if (control instanceof FormControl) {
  //       control.markAsTouched({ onlySelf: true });
  //     } else if (control instanceof FormGroup) {
  //       this.validateAllFormFields(control);
  //     }
  //   });
  // }

}

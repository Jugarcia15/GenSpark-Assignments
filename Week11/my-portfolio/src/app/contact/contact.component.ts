import { Component } from '@angular/core';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  submitForm(contactForm: any) {
    if (contactForm.valid) {
      // Process the form data, e.g., send it to a backend server
      console.log(contactForm.value); // Example: log the form data to the console
      contactForm.resetForm(); // Reset the form after submission
    }
  }
}

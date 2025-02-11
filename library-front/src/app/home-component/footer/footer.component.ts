import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.scss'
})
export class FooterComponent implements OnInit {
  userEmail! : string;

  ngOnInit(): void { }

  OnsubmitForm(form : NgForm): void{
    console.log(form.value);
  }
}

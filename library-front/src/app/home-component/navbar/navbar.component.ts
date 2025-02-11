import { Component, OnInit } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [
     RouterLink,
    RouterLinkActive,],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent implements OnInit {

 constructor(private router: Router ){}
   ngOnInit(): void {
  }

  onContinue(){
    this.router.navigateByUrl('books');
  }

}

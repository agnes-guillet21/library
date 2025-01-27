export class Book {

  id: string;

  constructor (public title: string,
    public description: string,
    public author: string,
    public isbn: number){

  this.id = crypto.randomUUID().substring(0, 8);
  console.log(this);
  }

}

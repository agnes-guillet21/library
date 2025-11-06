import { useDateFormat } from '@vueuse/core';

export default class BookModel {

    private id : Number;
    private  title : String;
    private description : String ;
    private isbn: Number;
    private addDate: Date;


    constructor (id: Number, title: String, description : String, isbn : Number, addDate: Date){
        this.id = id
        this.title = title
        this.description = description
        this.isbn = isbn
        this.addDate = addDate
    }

    public static convertFromApi(payload: any): BookModel {
        return new BookModel(
            payload.id,
            payload.title,
            payload.description,
            payload.isbn,
            useDateFormat(payload.addDate, 'DD/MM/YYYY')
           
        );
    }
    /**
     *     public static convertToApi(payload: any): BookModel {}
     */

}
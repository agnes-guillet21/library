


export class ImageService {


  public parseBase64Data(base64String: string, fileName: string) {
    const match = base64String.match(/^data:(.+);base64,(.+)$/);

    if (!match) {
      throw new Error("Format Base64 invalide !");
    }

    return {
      fileName: fileName,
      fileType: match[1],      // "image/png"
      base64Data: match[2]     // "iVBORw0KGgoAAAANSUhEUgAA"
    };
  }


}

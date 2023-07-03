package myclass;

public class albums
{
    private  int AlbumId;
    private  String Title;
    private  int ArtistId;

    public int getAlbumId() {
        return AlbumId;
    }

    public void setAlbumId(int albumId) {
        AlbumId = albumId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getArtistId() {
        return ArtistId;
    }

    public void setArtistId(int artistId) {
        ArtistId = artistId;
    }

    @Override
    public String toString() {
        return "albums{" +
                "AlbumId=" + AlbumId +
                ", Title='" + Title + '\'' +
                ", ArtistId=" + ArtistId +
                '}';
    }
}

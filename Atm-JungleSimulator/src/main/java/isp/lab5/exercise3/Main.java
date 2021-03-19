package isp.lab5.exercise3;

interface Playable {
    void play();
}

class ColorVideo implements Playable {

    private String fileName;

    public ColorVideo(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void play() {
        System.out.println("Play " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading video..." + fileName);
    }
}

class BlackAndWhiteVideo implements Playable {

    private String fileName;

    public BlackAndWhiteVideo(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void play() {
        System.out.println("Play black and white video {" + fileName + "}.");
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading video..." + fileName);
    }
}

class ProxyVideo implements Playable {
    private Playable video;
    private String fileName;
    private String type;

    public ProxyVideo(String fileName) {
        this.fileName = fileName;
        this.type = null;
    }

    public ProxyVideo(String fileName, String x) {
        this.fileName = fileName;
        this.type = x;
    }

    @Override
    public void play() {
        if ((video == null) && (type == null)) {
            video = new ColorVideo(fileName);
        } else {
            video = new BlackAndWhiteVideo(fileName);
        }
        video.play();
    }
}

public class Main {
    public static void main(String[] args) {
        ProxyVideo[] playables = new ProxyVideo[5];
        playables[0] = new ProxyVideo("Aliens");
        playables[1] = new ProxyVideo("Ocean", "2");
        playables[2] = new ProxyVideo("Game", "2");
        playables[3] = new ProxyVideo("Sports", "4");
        playables[4] = new ProxyVideo("Classified");
        for (int i = 0; i < playables.length; i++) {
            playables[i].play();
        }
    }
}

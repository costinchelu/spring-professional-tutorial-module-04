package module04.question23.auto.configuration.filestore.local;

import module04.question23.auto.configuration.filestore.FileStore;

class LocalFileStore implements FileStore {

    @Override
    public void printFileStoreInfo() {
        System.out.println("> local filestore");
    }
}

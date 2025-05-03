package module04.question23.auto.configuration.filestore.network;

import module04.question23.auto.configuration.filestore.FileStore;

class NetworkFileStore implements FileStore {

    @Override
    public void printFileStoreInfo() {
        System.out.println("> network filestore");
    }
}

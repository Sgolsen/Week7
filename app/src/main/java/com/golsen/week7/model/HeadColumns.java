package com.golsen.week7.model;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class HeadColumns {
    private DiscoveryColumns discoveryColumns;
    private EditorRecommendAlbums editorRecommendAlbums;
    private FocusImages focusImages;
    private SpecialColumns specialColumn;

    public DiscoveryColumns getDiscoveryColumns() {
        return discoveryColumns;
    }

    public void setDiscoveryColumns(DiscoveryColumns discoveryColumns) {
        this.discoveryColumns = discoveryColumns;
    }

    public EditorRecommendAlbums getEditorRecommendAlbums() {
        return editorRecommendAlbums;
    }

    public void setEditorRecommendAlbums(EditorRecommendAlbums editorRecommendAlbums) {
        this.editorRecommendAlbums = editorRecommendAlbums;
    }

    public FocusImages getFocusImages() {
        return focusImages;
    }

    public void setFocusImages(FocusImages focusImages) {
        this.focusImages = focusImages;
    }

    public SpecialColumns getSpecialColumn() {
        return specialColumn;
    }

    public void setSpecialColumn(SpecialColumns specialColumn) {
        this.specialColumn = specialColumn;
    }
}

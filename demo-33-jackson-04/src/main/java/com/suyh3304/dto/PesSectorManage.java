package com.suyh3304.dto;

import org.springframework.lang.NonNull;

/**
 * @author suyh
 * @since 2026-08-21
 */
public class PesSectorManage extends AbstractPesSector {
    @NonNull
    @Override
    public PesSectorEnums getSector() {
        return PesSectorEnums.MANAGE;
    }
}

/*
 * Copyright (c)  2017 Alen Turković <alturkovic@gmail.com>
 *
 * Permission to use, copy, modify, and distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.github.alturkovic.lock;

import java.util.List;

public interface Lock {
    /**
     * Try to acquire the lock.
     *
     * @param keys            keys to try to lock
     * @param storeId         lock store id to save keys in (table, collection, ...)
     * @param expiration      how long to wait before releasing the key automatically, in millis
     * @param retry           how much to wait before retrying to acquire the lock, in millis
     * @param timeout         how long to try to acquire before failing, in millis
     *
     * @return token to use for releasing the lock or {@code null} if lock cannot be acquired
     */
    String acquire(List<String> keys, String storeId, long expiration, long retry, long timeout);

    void release(List<String> keys, String token, String storeId);
}